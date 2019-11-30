package com.surf.advisor.map.supplier.service;

import com.surf.advisor.geolocation.api.model.GeoCluster;
import com.surf.advisor.geolocation.api.model.RectangleGeolocationRequest;
import com.surf.advisor.map.supplier.client.geo.api.GeolocationApiClient;
import com.surf.advisor.map.supplier.client.mapper.GeoMapper;
import com.surf.advisor.map.supplier.client.mapper.SpotMapper;
import com.surf.advisor.map.supplier.client.spot.api.SpotApiConnector;
import com.surf.advisor.map.supplier.domain.MapQuery;
import com.surf.advisor.map.supplier.util.CircleQueryUtils;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;
import com.surf.advisor.map.supplier.web.api.model.PointDetails;
import com.surf.advisor.map.supplier.web.api.model.PointId;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static com.surf.advisor.map.supplier.util.GridSnapUtils.snapToGrid;
import static com.surf.advisor.map.supplier.web.api.model.ObjectType.SPOT;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.apache.lucene.util.SloppyMath.haversinMeters;
import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapSupplier implements IMapSupplier {

    private final GeolocationApiClient geoClient;
    private final SpotApiConnector spotClient;

    @Override
    public MapSupplierResponse queryCircle(MapQuery query) {
        query.setRectangle(CircleQueryUtils.square(query.getCenter(), query.getRadius()));
        return queryRectangle(query);
    }

    @Override
    public MapSupplierResponse queryRectangle(MapQuery query) {

        var geolocations = getGeolocations(query.getRectangle());

        List<PointId> pointIds = new LinkedList<>();

        var pointDetails = geolocations.stream()
            .map(cluster -> new PointDetails()
                .coords(GeoMapper.INSTANCE.map(cluster))
                .pointIds(GeoMapper.INSTANCE.mapPointIds(cluster.getObjectIds()))
        )
            .peek(point -> pointIds.addAll(point.getPointIds()))
            .collect(toList());

        var filteredIds = filterSpotIds(query, pointIds);

        pointDetails = pointDetails.parallelStream()
            .peek(cluster -> cluster.getPointIds().removeIf(id -> !filteredIds.contains(id)))
            .filter(cluster -> !cluster.getPointIds().isEmpty())
            .peek(cluster -> handleSinglePoint(query, cluster))
            .peek(cluster -> cluster.setCluster(cluster.getPointIds().size() > 1))
            .collect(toList());

        return new MapSupplierResponse().points(pointDetails)
            .pointIds(filteredIds).matchedRectangle(query.getRectangle());
    }

    private List<GeoCluster> getGeolocations(Rectangle rec) {

        snapToGrid(rec);

        var request = new RectangleGeolocationRequest();
        request.setMinLatitude(rec.getPointA().getLatitude());
        request.setMinLongitude(rec.getPointA().getLongitude());
        request.setMaxLatitude(rec.getPointB().getLatitude());
        request.setMaxLongitude(rec.getPointB().getLongitude());

        return geoClient.getGeoClusters(request);
    }

    private List<PointId> filterSpotIds(MapQuery query, List<PointId> pointIds) {
        if (isEmpty(pointIds)) {
            return List.of();
        }
        var filters = SpotMapper.INSTANCE.map(query);
        filters.setIds(pointIds.stream().map(PointId::getObjectId).collect(toList()));

        var response = spotClient.filterSpotIds(filters);

        if (response == null) {
            return pointIds;
        }

        return response.getIds().stream()
            .map(id -> new PointId().objectId(id).objectType(SPOT)).collect(toList());
    }

    private void handleSinglePoint(MapQuery query, PointDetails cluster) {
        if (isSinglePoint(cluster)) {
            decorateDetails(cluster);
            correctCoords(cluster);
            computeDistance(query, cluster);
        }
    }

    private void decorateDetails(PointDetails point) {
        point.getPointIds().stream().findFirst()
            .map(id -> spotClient.getSpot(id.getObjectId()))
            .ifPresent(spot -> point.setSpot(SpotMapper.INSTANCE.map(spot)));
    }

    private void correctCoords(PointDetails point) {
        point.getPointIds().stream().findFirst()
            .map(id -> geoClient.getGeolocation(id.getObjectType().name(), id.getObjectId()))
            .ifPresent(pos -> point.setCoords(GeoMapper.INSTANCE.map(pos)));
    }

    private void computeDistance(MapQuery query, PointDetails point) {
        ofNullable(query.getReferenceLocation())
            .map(ref -> haversinMeters(ref.getLatitude(), ref.getLongitude(),
                point.getCoords().getLatitude(), point.getCoords().getLongitude())
            ).map(Double::intValue)
            .ifPresent(point::setDistance);
    }

    private boolean isSinglePoint(PointDetails cluster) {
        return cluster.getPointIds().size() == 1;
    }
}
