package com.ronnaces.ronna.boot.swagger;

import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthConstant;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024/1/9 17:06
 */
@Configuration
public class SwaggerConfig {

    private static final String title = "Ronnaces Open Api";
    private static final String description = "Ronnaces Open Api";
    private static final String name = "kunlong-luo";
    private static final String mail = "luokunlong.loong@gmail.com";
    private static final String version = "1.0.0";
    private static final String scheme = "bearer";
    private static final String bearerFormat = "JWT";

    @Bean
    public OpenAPI openApi() {
        Info info = new Info()
                .title(title)
                .description(description)
                .contact(new Contact().name(name).email(mail))
                .version(version);

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .scheme(scheme)
                .bearerFormat(bearerFormat);
        Components components = new Components()
                .addSecuritySchemes(AuthConstant.HEADER_AUTHORIZATION, securityScheme)
                .addParameters(AuthConstant.HEADER_AUTHORIZATION, new Parameter().in(SecurityScheme.In.HEADER.toString()).schema(new StringSchema()).name(""));
        return new OpenAPI()
                .info(info)
//                .components(components)
                ;
    }
}
