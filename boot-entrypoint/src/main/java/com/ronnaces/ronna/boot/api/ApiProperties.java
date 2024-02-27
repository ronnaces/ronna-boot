package com.ronnaces.ronna.boot.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ApiProperties
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 11:18
 */

@Getter
@Setter
@Component
@ConfigurationProperties(ApiProperties.LOONG_PREFIX)
public class ApiProperties {

    public static final String LOONG_PREFIX = "loong.api";

    private String title;

    private String description;

    private String name;

    private String mail;

    private String version;
    
}
