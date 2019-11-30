package com.surf.advisor.map.supplier.client.mapper;

import com.surf.advisor.geolocation.api.model.GeoCluster;
import com.surf.advisor.geolocation.api.model.Geolocation;
import com.surf.advisor.geolocation.api.model.LocationId;
import com.surf.advisor.map.supplier.web.api.model.PointCoords;
import com.surf.advisor.map.supplier.web.api.model.PointId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import static com.amazonaws.util.CollectionUtils.isNullOrEmpty;
import static java.util.Optional.of;

@Mapper
public interface GeoMapper {

    GeoMapper INSTANCE = Mappers.getMapper(GeoMapper.class);

    List<PointId> mapPointIds(Set<LocationId> locationIds);

    PointId map(LocationId id);

    PointCoords map(Geolocation geolocation);

    PointCoords map(GeoCluster cluster);

    default PointCoords map(List<Double> input) {
        if (isNullOrEmpty(input)) {
            return null;
        }
        var result = new PointCoords();

        Map.<Integer, BiConsumer<PointCoords, Double>>of(
            0, PointCoords::latitude,
            1, PointCoords::longitude
        ).forEach((idx, setter) -> of(idx).filter(i -> input.size() > i)
            .map(input::get).ifPresent(val -> setter.accept(result, val)));

        return result;
    }
}
