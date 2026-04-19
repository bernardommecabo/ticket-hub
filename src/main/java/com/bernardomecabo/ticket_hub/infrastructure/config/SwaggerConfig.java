package com.bernardomecabo.ticket_hub.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Ticket Hub")
                        .version("v1.0")
                        .description("TicketHub is a backend system designed to manage high-traffic event seat reservations. " +
                                "It focuses on data integrity, concurrency control, and clean architecture, showcasing modern software engineering patterns.")
                        .contact(new Contact()
                                .name("Bernardo Mecabô")
                                .email("contato.bernardo.mecabo@gmail.com")
                                .url("https://github.com/bernardommecabo/")));
    }
}
