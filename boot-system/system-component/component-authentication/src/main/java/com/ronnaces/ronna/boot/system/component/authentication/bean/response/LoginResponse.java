package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
     * token expires
     */
    @JsonFormat(
            pattern = "yyyy/MM/dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime expires;
    /**
     * username
     */
    private String username;
    /**
     * roles
     */
    private List<String> roles;
    /**
     * access token
     */
    private String accessToken;
    /**
     * refresh token
     */
    private String refreshToken;


}
