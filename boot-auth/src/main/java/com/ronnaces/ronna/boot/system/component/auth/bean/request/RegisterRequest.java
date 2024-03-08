package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "注册信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {


    @Schema(description = "账号")
    private String username;


    @Schema(description = "密码")
    private String password;


    @Schema(description = "电话号码")
    private String phone;


    @Schema(description = "验证码")
    private String smsCode;

}
