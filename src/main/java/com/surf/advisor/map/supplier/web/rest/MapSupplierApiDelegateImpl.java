package com.surf.advisor.map.supplier.web.rest;

import com.surf.advisor.map.supplier.domain.RectangleMapQuery;
import com.surf.advisor.map.supplier.service.IMapSupplier;
import com.surf.advisor.map.supplier.web.api.MapSupplierApiDelegate;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;
import com.surf.advisor.map.supplier.web.api.model.ObjectStatus;
import com.surf.advisor.map.supplier.web.api.model.ObjectType;
import com.surf.advisor.map.supplier.web.api.model.PointCoords;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapSupplierApiDelegateImpl implements MapSupplierApiDelegate {

    private final IMapSupplier mapSupplier;


    @Override
    public ResponseEntity<MapSupplierResponse> queryRectangle(List<Double> pointA,
                                                              List<Double> pointB,
                                                              List<ObjectType> objectTypes,
                                                              ObjectStatus status, String country,
                                                              String state, String city) {

        var rectangle = new Rectangle()
            .pointA(new PointCoords().latitude(pointA.get(0)).longitude(pointA.get(1)))
            .pointB(new PointCoords().latitude(pointB.get(0)).longitude(pointB.get(1)));

        var query = RectangleMapQuery.builder().rectangle(rectangle)
            .objectTypes(new HashSet<>(objectTypes)).status(status)
            .country(country).state(state).city(city)
            .build();

        return ResponseEntity.ok(mapSupplier.queryRectangle(query));
    }
}
