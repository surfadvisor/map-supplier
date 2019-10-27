package com.surf.advisor.map.supplier.client.geo.api;

import com.surf.advisor.geolocation.api.model.GeoCluster;
import com.surf.advisor.geolocation.api.model.Geolocation;
import com.surf.advisor.geolocation.api.model.RectangleGeolocationRequest;
import com.surf.advisor.map.supplier.config.FeignConfiguration;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "geolocation", url = "${feign.geolocation.url}", configuration = FeignConfiguration.class)
public interface GeolocationApiClient {

    @GetMapping("/geolocation/geolocations/clustered")
    List<GeoCluster> getGeoClusters(@RequestBody RectangleGeolocationRequest request);

    @GetMapping("/geolocation/geolocations/{type}/{id}")
    Geolocation getGeolocation(@PathVariable("type") String type, @PathVariable("id") String id);

}
