package com.surf.advisor.map.supplier.client;

import com.surf.advisor.map.supplier.security.SecurityUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String OVERRIDE_METHOD_HEADER = "X-HTTP-Method-Override";
    private static final String BEARER = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        SecurityUtils.getCurrentUserJWT()
            .ifPresent(s -> template.header(AUTHORIZATION_HEADER,String.format("%s %s", BEARER, s)));

        if ("GET".equals(template.method())) {
            template.header(OVERRIDE_METHOD_HEADER, "GET");
        }
    }
}
