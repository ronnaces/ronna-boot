package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Login
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@Schema(description = "登录响应对象")
public class LoginResponse {

    /**
     * userId
     */
    @Schema(description = "用户ID")
    private String userId;

    /**
     * roles
     */
    @Schema(description = "角色信息列表")
    private List<LoginRoleResponse> roles;

    /**
     * access token
     */
    @Schema(description = "token")
    private String token;
}
