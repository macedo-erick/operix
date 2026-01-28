package br.com.operix.peopleservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI peopleServiceOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("API Gateway");

        return new OpenAPI()
                .info(new Info()
                        .title("People Service API")
                        .description("People management API")
                        .version("1.0.0"))
                .servers(List.of(server));
    }
}
