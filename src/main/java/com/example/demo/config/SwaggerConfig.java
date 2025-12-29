package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "BearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {

        

        // Cloud server
        Server cloudServer = new Server()
                .url("https://9417.pro604cr.amypo.ai/")
                .description("Cloud Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Carbon Footprint Estimator API")
                        .version("1.0")
                        .description("REST APIs secured using JWT authentication"))
                .servers(List.of(localServer, cloudServer))

                // 🔐 Global security requirement
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))

                // 🔐 Security scheme definition
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
}
