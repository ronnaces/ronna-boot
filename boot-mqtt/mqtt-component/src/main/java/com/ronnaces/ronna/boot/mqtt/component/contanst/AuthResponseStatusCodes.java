package com.ronnaces.ronna.boot.mqtt.component.contanst;

import com.ronnaces.loong.common.enums.IResponseStatusCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AuthResponseStatusCodes implements IResponseStatusCodes {
    
    USER_ALREADY_EXISTS(5001, "用户已存在"),
    SMS_CODE_IS_NULL(5002, "短信验证码为空"),
    SMS_CODE_VERIFY_FAILURE(5003, "短信验证码校验失败"),
    USER_NOT_EXISTS(5004, "用户不存在");

    private final int code;

    private final String message;
}
