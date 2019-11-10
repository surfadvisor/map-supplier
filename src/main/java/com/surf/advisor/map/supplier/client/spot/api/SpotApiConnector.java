package com.surf.advisor.map.supplier.client.spot.api;

import com.surf.advisor.map.supplier.client.spot.model.Spot;
import com.surf.advisor.map.supplier.client.spot.model.SpotFilters;
import com.surf.advisor.map.supplier.client.spot.model.SpotIdListResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CacheConfig(cacheNames = "spots")
public class SpotApiConnector {

    private final SpotApiClient spotClient;

    @Cacheable
    public SpotIdListResponse filterSpotIds(@Valid SpotFilters filters) {
        return spotClient.filterSpotIds(filters).getBody();
    }

    @Cacheable
    public Spot getSpot(String id) {
        return spotClient.getSpot(id).getBody();
    }

}
