package com.ronnaces.ronna.boot.system.component.logging.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum LoginType {


    USERNAME(1),
    SMS(1),
    QRCODE(1),
    THIRDPARTY(1);

    private final int code;
}
