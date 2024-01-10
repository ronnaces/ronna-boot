package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * CaptchaInfo
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "校验码信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaRequest {

    @Schema(description = "密钥")
    private String key;

    /**
     * base64
     */
    @Schema(description = "base64")
    private String code;

    @Schema(description = "校验值")
    private String text;

}
