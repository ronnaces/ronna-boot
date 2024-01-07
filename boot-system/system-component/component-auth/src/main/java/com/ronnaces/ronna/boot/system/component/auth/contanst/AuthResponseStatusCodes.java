package com.ronnaces.ronna.boot.system.component.auth.contanst;

import com.ronnaces.loong.common.enums.IResponseStatusCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AuthorizationResponseStatusCodes
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/11 21:29
 */
@Getter
@AllArgsConstructor
public enum AuthResponseStatusCodes implements IResponseStatusCodes {
    /**
     * authentication
     */
    USER_ALREADY_EXISTS(5001, "user already exists"),
    SMS_CODE_IS_NULL(5002, "sms code is null"),
    SMS_CODE_VERIFY_FAILURE(5003, "sms code verify failure");

    private final int code;

    private final String message;
}
