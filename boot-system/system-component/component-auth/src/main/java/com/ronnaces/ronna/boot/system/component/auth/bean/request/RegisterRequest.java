package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * RegisterInfo
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "注册信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    /**
     * 账号
     */
    @Schema(description = "账号")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

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
