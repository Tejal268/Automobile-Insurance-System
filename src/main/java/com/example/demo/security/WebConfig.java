package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // allow all paths
                        .allowedOrigins("http://localhost:4200")  // allow Angular frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // common methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(true); // allow cookies/JWT
            }
        };
    }
}
