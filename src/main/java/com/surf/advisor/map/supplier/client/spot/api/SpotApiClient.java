package com.surf.advisor.map.supplier.client.spot.api;

import com.surf.advisor.map.supplier.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="spot-client", configuration = FeignConfiguration.class)
public interface SpotApiClient extends SpotApi {
}
