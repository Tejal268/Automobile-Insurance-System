package com.example.demo.security;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

 @Bean
 public OpenAPI customOpenAPI() {
     return new OpenAPI()
             .info(new Info()
                     .title("Automobile Insurance System")
                     .version("1.0")
                     .description("API documentation for JWT-based secure endpoints"))
             .components(new Components()
                     .addSecuritySchemes("BearerAuth",
                             new SecurityScheme()
                                     .type(SecurityScheme.Type.HTTP)
                                     .scheme("bearer")
                                     .bearerFormat("JWT")
                                     .in(SecurityScheme.In.HEADER)
                                     .name("Authorization")
                     ))
             .addSecurityItem(new SecurityRequirement().addList("BearerAuth", List.of("read", "write")));
 }
}
