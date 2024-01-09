package com.ronnaces.ronna.boot.swagger;

import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.ronna.boot.system.component.auth.contanst.AuthConstant;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.commons.lang3.StringUtils;
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

    @Bean
    public OpenAPI openApi() {
        Info version = new Info()
                .title("Ronna Open Api")
                .description("Ronna Open Api")
                .contact(new Contact().name("kunlong-luo").email("luokunlong.loong@gmail.com"))
                .version("1.0.0");

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("JWT");

        return new OpenAPI()
                .info(version)
                .components(new Components().addSecuritySchemes(StringUtils.joinWith(CommonConstant.SPACE, AuthConstant.HEADER_AUTHORIZATION_BEARER, AuthConstant.HEADER_AUTHORIZATION), securityScheme))
                .addSecurityItem(new SecurityRequirement().addList(StringUtils.joinWith(CommonConstant.SPACE, AuthConstant.HEADER_AUTHORIZATION_BEARER, AuthConstant.HEADER_AUTHORIZATION)))
                ;
    }
}
