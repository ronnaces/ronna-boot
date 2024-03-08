package com.ronnaces.ronna.boot.system.modules.user.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;


@Getter
@AllArgsConstructor
public enum GenderEnum {

    
    UNKNOWN(1, "未知"),

    
    MALE(2, "男"),

    
    FEMALE(3, "女");

    private final Integer key;

    @JsonFormat
    private final String value;

    public static GenderEnum convert(Integer key) {
        return Stream.of(values())
                .filter(bean -> bean.key.equals(key))
                .findAny()
                .orElse(UNKNOWN);
    }

    public static GenderEnum convert(String value) {
        return Stream.of(values())
                .filter(bean -> bean.value.equals(value))
                .findAny()
                .orElse(UNKNOWN);
    }
}