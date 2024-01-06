package com.ronnaces.ronna.boot.system.component.authentication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * RouteType
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2021/8/21 10:19
 */
@Getter
@AllArgsConstructor
public enum RouteType {

    TOP(1, () -> "top"),
    FIRST(2, () -> "first"),
    BUTTON(3, () -> "button"),
    ;

    private static final Map<Integer, RouteType> MAP = Arrays.stream(values()).collect(Collectors.toMap(v -> v.id, Function.identity()));
    private final Integer id;
    private final Supplier<String> value;

    public static RouteType match(int id) {
        RouteType value1 = MAP.get(id);
        return Optional.of(value1).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public static Supplier<String> matchValue(int id) {
        return Optional.of(MAP.get(id).getValue()).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public static RouteType match(String value) {
        for (RouteType entity : RouteType.values()) {
            if (StringUtils.equals(entity.value.get(), value)) {
                return entity;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static Integer matchId(String value) {
        for (RouteType entity : RouteType.values()) {
            if (StringUtils.equals(entity.value.get(), value)) {
                return entity.id;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
