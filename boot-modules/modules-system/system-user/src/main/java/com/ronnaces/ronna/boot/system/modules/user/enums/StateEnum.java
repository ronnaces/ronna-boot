package com.ronnaces.ronna.boot.system.modules.user.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;


@Getter
@AllArgsConstructor
public enum StateEnum {


    NORMAL(1, "正常"),
    LOCK(2, "锁定"),
    DISABLED(3, "禁用");

    private final Integer key;

    @JsonFormat
    private final String value;

    public static StateEnum convert(Integer key) {
        return Stream.of(values())
                .filter(bean -> bean.key.equals(key))
                .findAny()
                .orElse(NORMAL);
    }

    public static StateEnum convert(String value) {
        return Stream.of(values())
                .filter(bean -> bean.value.equals(value))
                .findAny()
                .orElse(NORMAL);
    }
}