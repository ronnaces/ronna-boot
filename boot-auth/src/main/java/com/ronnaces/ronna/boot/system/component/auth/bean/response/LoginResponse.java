package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "登录响应对象")
public class LoginResponse {

    @Schema(description = "用户信息")
    private UserResponse user;

    @Schema(description = "Token")
    private String accessToken;

    @Schema(description = "刷新Token")
    private String refreshToken;
}
