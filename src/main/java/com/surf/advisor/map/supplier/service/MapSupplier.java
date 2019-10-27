package com.surf.advisor.map.supplier.service;

import static com.surf.advisor.map.supplier.util.GridSnapUtils.snapToGrid;
import static java.util.stream.Collectors.toList;

import com.surf.advisor.geolocation.api.model.GeoCluster;
import com.surf.advisor.geolocation.api.model.LocationId;
import com.surf.advisor.geolocation.api.model.RectangleGeolocationRequest;
import com.surf.advisor.map.supplier.client.geo.api.GeolocationApiClient;
import com.surf.advisor.map.supplier.client.mapper.GeoMapper;
import com.surf.advisor.map.supplier.domain.RectangleMapQuery;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;
import com.surf.advisor.map.supplier.web.api.model.PointCoords;
import com.surf.advisor.map.supplier.web.api.model.PointId;
import com.surf.advisor.map.supplier.web.api.model.PointShortInfo;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapSupplier implements IMapSupplier {

    private final GeolocationApiClient geoClient;

    @Override
    public MapSupplierResponse queryRectangle(RectangleMapQuery query) {

        var geolocations = getGeolocations(query.getRectangle());

        List<PointId> pointIds = new LinkedList<>();

        var shortInfos = geolocations.stream()
            .map(cluster -> new PointShortInfo()
                .cluster(cluster.getObjectIds().size() > 1)
                .coords(new PointCoords()
                    .latitude(cluster.getLatitude())
                    .longitude(cluster.getLongitude())
                )
                .pointIds(mapPointIds(cluster.getObjectIds()))
        )
            .peek(point -> pointIds.addAll(point.getPointIds()))
            .collect(toList());

        return new MapSupplierResponse().points(shortInfos)
            .pointIds(pointIds).matchedRectangle(query.getRectangle());
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
}
