package com.main.gateway.config;

import com.main.gateway.filter.TokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author roxy
 */
@Slf4j
@Configuration
public class FilterConfig {
    @Bean
    public RouteLocator userRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //需要token认证的请求地址
                .route(r -> r.path("/hello", "/user/setdata", "/address/**")
                        .filters(f -> f.filter(new TokenFilter()))
                        .uri("http://localhost:8000"))
                .build();
    }

    @Bean
    public RouteLocator commodityManageRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //需要token认证的请求地址
                .route(r -> r.path("/comm-manage/**")
                        .filters(f -> f.filter(new TokenFilter()))
                        .uri("http://localhost:8001"))
                .build();
    }

    @Bean
    public RouteLocator shoppingRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //需要token认证的请求地址
                .route(r -> r.path("/shopping-car/**", "/order/**")
                        .filters(f -> f.filter(new TokenFilter()))
                        .uri("http://localhost:8003"))
                .build();
    }
}
