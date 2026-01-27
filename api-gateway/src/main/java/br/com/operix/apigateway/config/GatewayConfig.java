package br.com.operix.apigateway.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public GroupedOpenApi productServiceApi() {
        return GroupedOpenApi.builder()
                .group("product-service")
                .displayName("Product Service")
                .pathsToMatch("/api/products/**")
                .build();
    }

    @Bean
    public GroupedOpenApi peopleServiceApi() {
        return GroupedOpenApi.builder()
                .group("people-service")
                .displayName("People Service")
                .pathsToMatch("/api/people/**")
                .build();
    }

    @Bean
    public GroupedOpenApi inventoryServiceApi() {
        return GroupedOpenApi.builder()
                .group("inventory-service")
                .displayName("Inventory Service")
                .pathsToMatch("/api/inventory/**")
                .build();
    }
}
