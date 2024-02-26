package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * RefreshToken
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
public class RefreshTokenResponse {

    /**
     * token expires
     */
    @JsonFormat(
            pattern = "yyyy/MM/dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime expires;
    /**
     * access token
     */
    private String accessToken;
    /**
     * refresh token
     */
    private String refreshToken;
}
