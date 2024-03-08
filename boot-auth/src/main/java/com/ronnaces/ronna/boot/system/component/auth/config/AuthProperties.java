package com.ronnaces.ronna.boot.system.component.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Getter
@Setter
@Component
@ConfigurationProperties(AuthProperties.LOONG_AUTH_PREFIX)
public class AuthProperties {

    public static final String LOONG_AUTH_PREFIX = "loong.auth";

    private String[] permits;


    private String defaultPassword = "88888888";


    private Long accessTokenExpire = 24 * 60 * 60 * 1000L;

    private Long refreshTokenExpire = 24 * 60 * 60 * 1000L;
}
