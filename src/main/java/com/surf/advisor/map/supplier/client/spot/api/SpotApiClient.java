package com.surf.advisor.map.supplier.client.spot.api;

import com.surf.advisor.map.supplier.client.spot.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${spot.name:spot}", url="${spot.url:http://localhost}", configuration = ClientConfiguration.class)
public interface SpotApiClient extends SpotApi {
}
