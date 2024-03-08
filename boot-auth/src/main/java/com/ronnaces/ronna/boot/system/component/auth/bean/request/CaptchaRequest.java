package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "校验码信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaRequest {

    @Schema(description = "密钥")
    private String key;

    
    @Schema(description = "base64")
    private String code;

    @Schema(description = "校验值")
    private String text;

}
