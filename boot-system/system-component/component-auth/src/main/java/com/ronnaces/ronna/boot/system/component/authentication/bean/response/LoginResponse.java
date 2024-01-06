package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

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
public class LoginResponse {

    /**
     * username
     */
    private String userId;

    /**
     * roles
     */
    private List<LoginRoleResponse> roles;

    /**
     * access token
     */
    private String token;
}
