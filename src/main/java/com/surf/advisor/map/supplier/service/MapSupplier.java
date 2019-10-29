package com.surf.advisor.map.supplier.service;

import static com.surf.advisor.map.supplier.util.GridSnapUtils.snapToGrid;
import static com.surf.advisor.map.supplier.web.api.model.ObjectType.SPOT;
import static java.util.stream.Collectors.toList;

import com.surf.advisor.geolocation.api.model.GeoCluster;
import com.surf.advisor.geolocation.api.model.LocationId;
import com.surf.advisor.geolocation.api.model.RectangleGeolocationRequest;
import com.surf.advisor.map.supplier.client.geo.api.GeolocationApiClient;
import com.surf.advisor.map.supplier.client.mapper.GeoMapper;
import com.surf.advisor.map.supplier.client.mapper.SpotMapper;
import com.surf.advisor.map.supplier.client.spot.api.SpotApiClient;
import com.surf.advisor.map.supplier.client.spot.model.SpotFilters;
import com.surf.advisor.map.supplier.domain.RectangleMapQuery;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;
import com.surf.advisor.map.supplier.web.api.model.PointId;
import com.surf.advisor.map.supplier.web.api.model.PointShortInfo;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapSupplier implements IMapSupplier {

    private final GeolocationApiClient geoClient;
    private final SpotApiClient spotClient;

    @Override
    public MapSupplierResponse queryRectangle(RectangleMapQuery query) {

        var geolocations = getGeolocations(query.getRectangle());

        List<PointId> pointIds = new LinkedList<>();

        var shortInfos = geolocations.stream()
            .map(cluster -> new PointShortInfo()
                .cluster(cluster.getObjectIds().size() > 1)
                .coords(GeoMapper.INSTANCE.map(cluster))
                .pointIds(mapPointIds(cluster.getObjectIds()))
        )
            .peek(point -> pointIds.addAll(point.getPointIds()))
            .collect(toList());

        var filteredIds = filterSpotIds(query, pointIds);

        shortInfos = shortInfos.parallelStream()
            .peek(cluster -> cluster.getPointIds().removeIf(id -> !filteredIds.contains(id)))
            .filter(cluster -> !cluster.getPointIds().isEmpty())
            .peek(this::decorateDetails)
            .peek(this::correctCoords)
            .collect(toList());

        return new MapSupplierResponse().points(shortInfos)
            .pointIds(filteredIds).matchedRectangle(query.getRectangle());
    }

    private List<PointId> mapPointIds(Set<LocationId> locationIds) {
        return locationIds.stream().map(GeoMapper.INSTANCE::map).collect(toList());
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

    private List<PointId> filterSpotIds(RectangleMapQuery query, List<PointId> pointIds) {

        var ids = pointIds.stream().map(PointId::getObjectId).collect(toList());

        var filters = new SpotFilters().ids(ids)
            .status(List.of(SpotMapper.INSTANCE.map(query.getStatus())))
            .country(query.getCountry())
            .state(query.getState())
            .city(query.getCity());

        var response = spotClient.filterSpotIds(filters);

        if (response.getBody() == null) {
            log.error("Spot API response code: {}, skip filtering", response.getStatusCode());
            return pointIds;
        }

        return response.getBody().getIds().stream()
            .map(id -> new PointId().objectId(id).objectType(SPOT)).collect(toList());
    }

    private void decorateDetails(PointShortInfo cluster) {
        if (isSinglePoint(cluster)) {
            //TODO: retrieve spot details and decorate that single point with it
        }
    }

    private void correctCoords(PointShortInfo cluster) {
        if (isSinglePoint(cluster)) {
            cluster.getPointIds().stream().findFirst()
                .map(id -> geoClient.getGeolocation(id.getObjectType().name(), id.getObjectId()))
                .ifPresent(pos -> cluster.setCoords(GeoMapper.INSTANCE.map(pos)));
        }
    }

    private boolean isSinglePoint(PointShortInfo cluster) {
        return cluster.getPointIds().size() == 1;
    }
}
