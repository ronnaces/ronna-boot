package com.ronnaces.ronna.boot.system.component.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AuthProperties
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 11:18
 */

@Getter
@Setter
@Component
@ConfigurationProperties(AuthProperties.LOONG_AUTH_PREFIX)
public class AuthProperties {

    public static final String LOONG_AUTH_PREFIX = "loong.auth";

    private String[] permits;

    /**
     * 默认密码是：88888888
     */
    private String defaultPassword = "88888888";

    /**
     * WEB端过期时间默认是1天
     */
    private Long accessTokenExpire = 24 * 60 * 60 * 1000L;

    private Long refreshTokenExpire = 24 * 60 * 60 * 1000L;
}
