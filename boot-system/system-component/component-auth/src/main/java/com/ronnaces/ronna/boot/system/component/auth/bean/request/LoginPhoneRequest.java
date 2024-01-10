package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * LoginPhoneRequest
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Schema(description = "手机登录请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginPhoneRequest {

    /**
     * 电话号码
     */
    @Schema(description = "电话号码")
    private String phone;

    /**
     * 验证码
     */
    @Schema(description = "验证码")
    private String smsCode;
}
