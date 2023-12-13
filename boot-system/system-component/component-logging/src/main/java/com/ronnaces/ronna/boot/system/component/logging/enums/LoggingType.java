package com.ronnaces.ronna.boot.system.component.logging.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LoggingType
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/18 20:36
 */
@Getter
@AllArgsConstructor
public enum LoggingType {

    /**
     * 类型: 1-登录日志, 2-访问日志
     */
    LOGIN_LOG(1),
    EDIT_LOG(2);

    private final int code;
}
