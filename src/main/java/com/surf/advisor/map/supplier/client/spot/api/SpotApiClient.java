package com.surf.advisor.map.supplier.client.spot.api;

import com.surf.advisor.map.supplier.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="spots", url="${feign.spots.url}", configuration = FeignConfiguration.class)
public interface SpotApiClient extends SpotApi {
}
