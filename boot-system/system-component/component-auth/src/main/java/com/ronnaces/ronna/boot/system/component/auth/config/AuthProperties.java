package com.ronnaces.ronna.boot.system.component.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AuthenticationProperties
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 11:18
 */

@Getter
@Setter
@Component
@ConfigurationProperties(AuthProperties.LOONG_AUTHENTICATION_PREFIX)
public class AuthProperties {

    public static final String LOONG_AUTHENTICATION_PREFIX = "loong.authentication";

    private List<String> permits;

    private String defaultPassword;

    private Long accessTokenExpire = 1000 * 60 * 60 * 1000L;

    private Long refreshTokenExpire = 2000 * 60 * 60 * 1000L;
}
