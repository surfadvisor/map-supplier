package com.surf.advisor.map.supplier.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String OVERRIDE_METHOD_HEADER = "X-HTTP-Method-Override";


    @Override
    public void apply(RequestTemplate template) {

        if ("GET".equals(template.method())) {
            template.header(OVERRIDE_METHOD_HEADER, "GET");
        }
    }
}
