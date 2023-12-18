package com.ronnaces.ronna.boot.system.component.logging.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LoginType
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/18 20:36
 */
@Getter
@AllArgsConstructor
public enum LoginType {

    /**
     * 类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录
     */
    USERNAME(1),
    SMS(1),
    QRCODE(1),
    THIRDPARTY(1);

    private final int code;
}
