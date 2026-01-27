package br.com.operix.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                                .name("Operix Team")));
    }
}
