package com.project.APIGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes().
                route(p -> p
                        .path("/niit/auth/**")
                        .uri("http://localhost:8084/")
                )
                .route(p -> p
                        .path("/bookings/**")
                        .uri("http://localhost:8081/")
                )
                .route(p -> p
                        .path("/eventData/**")
                        .uri("http://localhost:8088/")
                )
                .route(p -> p
                        .path("/payment/**")
                        .uri("http://localhost:8085/")
                )
                .route(p -> p
                        .path("/api/v4/**")
                        .uri("http://localhost:8086/")
                )
                .route(p -> p
                        .path("/userData/**")
                        .uri("http://localhost:8082/"))

                .build();
    }
}
