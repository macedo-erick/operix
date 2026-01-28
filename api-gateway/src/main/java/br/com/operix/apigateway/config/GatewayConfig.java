package br.com.operix.apigateway.config;

import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return route("product-service")
                .route(path("/api/products/**"), HandlerFunctions.http())
                .filter(lb("product-service"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> peopleServiceRoute() {
        return route("people-service")
                .route(path("/api/people/**"), HandlerFunctions.http())
                .filter(lb("people-service"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return route("inventory-service")
                .route(path("/api/inventory/**"), HandlerFunctions.http())
                .filter(lb("inventory-service"))
                .build();
    }
}
