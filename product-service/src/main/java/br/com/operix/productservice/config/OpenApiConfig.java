package br.com.operix.productservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productServiceOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("API Gateway");

        return new OpenAPI()
                .info(new Info()
                        .title("Product Service API")
                        .description("API para gerenciamento de produtos")
                        .version("1.0.0"))
                .servers(List.of(server));
    }
}
