package com.surf.advisor.map.supplier.service;

import com.surf.advisor.map.supplier.web.api.MapSupplierApiDelegate;
import com.surf.advisor.map.supplier.web.api.model.MapSupplierResponse;
import com.surf.advisor.map.supplier.web.api.model.ObjectType;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MapSupplierApiDelegateImpl implements MapSupplierApiDelegate {

    @Override
    public ResponseEntity<MapSupplierResponse> queryRectangle(List<Double> pointA,
                                                              List<Double> pointB,
                                                              List<ObjectType> objectTypes) {
        return ResponseEntity.ok(new MapSupplierResponse());
    }
}
