package com.exercicio.valendonota.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Serratec - Desenvolvimento de API - Exercicio 1")
                        .description("GRUPO 4 - API Rest para o primeiro exercício")
                        .version("1.0")
                        .termsOfService("Open Source"));
    }
}