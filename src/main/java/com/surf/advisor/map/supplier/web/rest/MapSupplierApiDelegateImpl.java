package com.surf.advisor.map.supplier.web.rest;

import com.surf.advisor.map.supplier.client.mapper.GeoMapper;
import com.surf.advisor.map.supplier.domain.MapQuery;
import com.surf.advisor.map.supplier.service.IMapSupplier;
import com.surf.advisor.map.supplier.web.api.MapSupplierApiDelegate;
import com.surf.advisor.map.supplier.web.api.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MapSupplierApiDelegateImpl implements MapSupplierApiDelegate {

    private final IMapSupplier mapSupplier;

    @Override
    public ResponseEntity<MapSupplierResponse> queryRectangle(List<Double> pointA, List<Double> pointB,
                                                              List<ObjectType> objectTypes, List<Double> refPoint,
                                                              List<ObjectStatus> status, List<CountryCode> country,
                                                              List<SpotFacility> facilities, List<Difficulty> difficulty,
                                                              List<Depth> depth, List<SportType> sportTypes,
                                                              List<WaterType> waterType, List<Integer> waveAvgPeriod,
                                                              List<Integer> waveAvgSize) {
        var rectangle = new Rectangle()
            .pointA(GeoMapper.INSTANCE.map(pointA))
            .pointB(GeoMapper.INSTANCE.map(pointB));

        var query = MapQuery.builder().rectangle(rectangle)
            .referenceLocation(GeoMapper.INSTANCE.map(refPoint))
            .objectTypes(new HashSet<>(objectTypes)).status(status)
            .country(country).facilities(facilities).difficulty(difficulty)
            .sportTypes(sportTypes).waterType(waterType).depth(depth)
            .waveAvgPeriod(waveAvgPeriod).waveAvgSize(waveAvgSize)
            .build();

        return ResponseEntity.ok(mapSupplier.queryRectangle(query));
    }

    @Override
    public ResponseEntity<MapSupplierResponse> queryCircle(List<Double> point, Integer radius,
                                                           List<ObjectType> objectTypes, List<Double> refPoint,
                                                           List<ObjectStatus> status, List<CountryCode> country,
                                                           List<SpotFacility> facilities, List<Difficulty> difficulty,
                                                           List<Depth> depth, List<SportType> sportTypes,
                                                           List<WaterType> waterType, List<Integer> waveAvgPeriod,
                                                           List<Integer> waveAvgSize) {
        var query = MapQuery.builder().radius(radius)
            .center(new PointCoords().latitude(point.get(0)).longitude(point.get(1)))
            .referenceLocation(GeoMapper.INSTANCE.map(refPoint))
            .objectTypes(new HashSet<>(objectTypes)).status(status)
            .country(country).facilities(facilities).difficulty(difficulty)
            .sportTypes(sportTypes).waterType(waterType).depth(depth)
            .waveAvgPeriod(waveAvgPeriod).waveAvgSize(waveAvgSize)
            .build();

        return ResponseEntity.ok(mapSupplier.queryCircle(query));
    }

}
