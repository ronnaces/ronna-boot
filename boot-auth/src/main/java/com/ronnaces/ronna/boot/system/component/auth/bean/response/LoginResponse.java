package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

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

    @Schema(description = "角色信息")
    private Set<String> roles;

    @Schema(description = "刷新Token")
    private String username;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "过期时间")
    @JsonFormat(
            pattern = "yyyy/MM/dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime expires;
}
