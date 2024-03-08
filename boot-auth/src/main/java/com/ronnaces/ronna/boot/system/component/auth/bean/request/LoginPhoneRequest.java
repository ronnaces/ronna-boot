package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Schema(description = "手机登录请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginPhoneRequest {


    @Schema(description = "电话号码")
    private String phone;


    @Schema(description = "验证码")
    private String smsCode;
}
