package com.ronnaces.ronna.boot.system.component.authentication.bean.request;

import lombok.*;

/**
 * LoginPhoneRequest
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
public class LoginPhoneRequest {

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 验证码
     */
    private String smsCode;
}
