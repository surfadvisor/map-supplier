package com.surf.advisor.map.supplier.client.mapper;

import com.surf.advisor.geolocation.api.model.LocationId;
import com.surf.advisor.map.supplier.web.api.model.PointId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoMapper {

    GeoMapper INSTANCE = Mappers.getMapper(GeoMapper.class);

    PointId map(LocationId id);

}
