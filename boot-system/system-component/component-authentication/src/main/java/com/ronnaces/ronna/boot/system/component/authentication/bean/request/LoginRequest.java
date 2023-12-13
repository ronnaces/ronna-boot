package com.ronnaces.ronna.boot.system.component.authentication.bean.request;

import lombok.*;

/**
 * LoginInfo
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
