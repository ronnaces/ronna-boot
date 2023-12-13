package com.ronnaces.ronna.boot.system.component.authentication.bean.request;

import lombok.*;

/**
 * CaptchaInfo
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
public class CaptchaRequest {

    private String key;

    /**
     * base64
     */
    private String code;

    private String text;

}
