package com.ronnaces.ronna.boot.enums;

import com.ronnaces.loong.common.enums.IResponseStatusCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum GlobalStatusCodes implements IResponseStatusCodes {


    USER_ALREADY_EXISTS(HttpStatus.UNAUTHORIZED.value(), "用户已存在"),
    SMS_CODE_IS_NULL(HttpStatus.BAD_REQUEST.value(), "短信验证码不能为空"),
    SMS_CODE_VERIFY_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR.value(), "短信验证码校验失败"),
    DATASOURCE_MAPPING_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR.value(), "数据库映射异常"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "认证失败，请重新登录")
    ;

    private final int code;

    private final String message;
}
