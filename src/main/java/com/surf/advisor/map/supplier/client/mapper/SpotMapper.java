package com.surf.advisor.map.supplier.client.mapper;

import com.surf.advisor.map.supplier.client.spot.model.SpotFilters.StatusEnum;
import com.surf.advisor.map.supplier.web.api.model.ObjectStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SpotMapper {

    SpotMapper INSTANCE = Mappers.getMapper(SpotMapper.class);

    StatusEnum map(ObjectStatus status);
}
