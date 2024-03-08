package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RefreshTokenResponse {


    @JsonFormat(
            pattern = "yyyy/MM/dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime expires;

    private String accessToken;

    private String refreshToken;
}
