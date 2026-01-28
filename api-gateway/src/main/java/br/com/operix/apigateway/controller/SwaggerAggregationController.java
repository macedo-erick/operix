package br.com.operix.apigateway.controller;

import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

import java.util.List;

@RestController
public class SwaggerAggregationController {

    private final DiscoveryClient discoveryClient;
    private final SwaggerUiConfigParameters swaggerUiConfigParameters;

    public SwaggerAggregationController(DiscoveryClient discoveryClient, SwaggerUiConfigParameters swaggerUiConfigParameters) {
        this.discoveryClient = discoveryClient;
        this.swaggerUiConfigParameters = swaggerUiConfigParameters;
    }

    @PostConstruct
    public void init() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            if (!service.equals("api-gateway") && !service.equals("service-registry") && !service.equals("config-server")) {
                swaggerUiConfigParameters.addGroup(service);
            }
        }
    }
}
