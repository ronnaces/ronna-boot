package com.ronnaces.ronna.boot.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ApiConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024/1/9 17:06
 */
@RequiredArgsConstructor
@Configuration
public class ApiConfig {

    private final ApiProperties properties;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(properties.getTitle())
                        .description(properties.getDescription())
                        .contact(new Contact().name(properties.getName()).email(properties.getMail()))
                        .version(properties.getVersion()));
    }
}
