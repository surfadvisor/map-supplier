package com.surf.advisor.map.supplier.util;

import com.surf.advisor.map.supplier.client.mapper.GeoMapper;
import com.surf.advisor.map.supplier.web.api.model.PointCoords;
import com.surf.advisor.map.supplier.web.api.model.Rectangle;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CircleQueryUtils {

    public static Rectangle square(PointCoords center, Integer radius) {
        //TODO: proper implementation
        return new Rectangle()
            .pointA(GeoMapper.INSTANCE.map(List.of(center.getLatitude() + radius, center.getLongitude() + radius)))
            .pointB(GeoMapper.INSTANCE.map(List.of(center.getLatitude() - radius, center.getLongitude() - radius)));
    }
}
