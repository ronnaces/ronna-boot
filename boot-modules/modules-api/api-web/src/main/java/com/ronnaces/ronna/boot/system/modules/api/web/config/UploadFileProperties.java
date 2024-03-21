package com.ronnaces.ronna.boot.system.modules.api.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * UploadFileProperties
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 11:18
 */

@Getter
@Setter
@Component
@ConfigurationProperties(UploadFileProperties.LOONG_PREFIX)
public class UploadFileProperties {

    public static final String LOONG_PREFIX = "loong.files";

    private String data;
}
