package com.surf.advisor.map.supplier.client.mapper;

import com.surf.advisor.map.supplier.client.spot.model.IntegerRange;
import com.surf.advisor.map.supplier.client.spot.model.SpotFilters;
import com.surf.advisor.map.supplier.client.spot.model.SpotStatus;
import com.surf.advisor.map.supplier.domain.MapQuery;
import com.surf.advisor.map.supplier.web.api.model.ObjectStatus;
import com.surf.advisor.map.supplier.web.api.model.Spot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static com.amazonaws.util.CollectionUtils.isNullOrEmpty;
import static java.util.Optional.of;

@Mapper
public interface SpotMapper {

    SpotMapper INSTANCE = Mappers.getMapper(SpotMapper.class);

    SpotStatus map(ObjectStatus status);

    Spot map(com.surf.advisor.map.supplier.client.spot.model.Spot spot);

    SpotFilters map(MapQuery query);

    default IntegerRange map(List<Integer> input) {
        if (isNullOrEmpty(input)) {
            return null;
        }
        var result = new IntegerRange();

        Map.<Integer, BiConsumer<IntegerRange, Integer>>of(
            0, IntegerRange::from,
            1, IntegerRange::to
        ).forEach((idx, setter) -> of(idx).filter(i -> input.size() > i)
            .map(input::get).ifPresent(val -> setter.accept(result, val)));

        return result;
    }
}
