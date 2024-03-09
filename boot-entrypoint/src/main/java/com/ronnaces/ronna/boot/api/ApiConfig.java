package com.ronnaces.ronna.boot.api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;


@RequiredArgsConstructor
@Configuration
public class ApiConfig {

    private final ApiProperties apiDocInfo;

    /**
     * OAuth2 认证 endpoint
     */
//    @Value("${spring.security.oauth2.authorizationserver.token-uri}")
//    private String tokenUrl;

    /**
     * OpenAPI 配置（元信息、安全协议）
     */
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .components(new Components()
                                .addSecuritySchemes(HttpHeaders.AUTHORIZATION,
                                        new SecurityScheme()
//                                        // OAuth2 授权模式
//                                        .type(SecurityScheme.Type.OAUTH2)
//                                        .name(HttpHeaders.AUTHORIZATION)
//                                        .flows(new OAuthFlows()
//                                                .password(
//                                                        new OAuthFlow()
//                                                                .tokenUrl(tokenUrl)
//                                                                .refreshUrl(tokenUrl)
//                                                )
//                                        )
                                                // 安全模式使用Bearer令牌（即JWT）
                                                .in(SecurityScheme.In.HEADER)
                                                .scheme("Bearer")
                                                .bearerFormat("JWT")
                                )
                )
                // 接口全局添加 Authorization 参数
                .addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                // 接口文档信息(不重要)
                .info(new Info()
                        .title(apiDocInfo.getTitle())
                        .version(apiDocInfo.getVersion())
                        .description(apiDocInfo.getDescription())
                        .contact(new Contact()
                                .name(apiDocInfo.getContact().getName())
                                .url(apiDocInfo.getContact().getUrl())
                                .email(apiDocInfo.getContact().getEmail())
                        )
                        .license(new License().name(apiDocInfo.getLicense().getName())
                                .url(apiDocInfo.getLicense().getUrl())
                        ));
    }
}
