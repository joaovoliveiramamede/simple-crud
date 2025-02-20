package com.simplecrud.backend.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI clientOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Clientes")
                        .version("1.0.0")
                        .description("API para gerenciar clientes com Spring Boot")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .url("https://github.com/seu-repositorio")
                                .email("email@exemplo.com")));
    }
}
