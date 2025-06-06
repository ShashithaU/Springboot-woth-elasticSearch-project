package com.example.demo.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Your API Title", version = "v1", description = "API documentation for your application"))
public class OpenApiConfig {
    // Class body - can be empty or contain additional configuration methods
}