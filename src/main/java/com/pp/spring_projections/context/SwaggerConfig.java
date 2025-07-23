package com.pp.spring_projections.context;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api de Usuarios")
                        .description("API REST ejemplo de Spring Projections.")
                        .version("v1")
                        .contact(new Contact()
                                .name("TUP - UTN")
                                .url("www.example.com")
                                .email("myeaddress@company.com"))
                        .license(new License()
                                .name("License of API")
                                .url("API license URL")));
    }
}