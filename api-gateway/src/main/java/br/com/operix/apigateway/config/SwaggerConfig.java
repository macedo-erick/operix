package br.com.operix.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiGatewayOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Operix API Gateway")
                        .description("API Gateway - Central point for Operix Microservices")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Operix Team")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("API Gateway"),
                        new Server()
                                .url("http://localhost:8081")
                                .description("Product Service"),
                        new Server()
                                .url("http://localhost:8082")
                                .description("People Service"),
                        new Server()
                                .url("http://localhost:8083")
                                .description("Inventory Service")
                ));
    }
}
