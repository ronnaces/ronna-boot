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
 * UserState
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2021/8/21 10:19
 */
@Getter
@AllArgsConstructor
public enum UserState {

    NORMAL(1, () -> "normal"),
    LOCKED(2, () -> "locked"),
    DISABLED(3, () -> "disabled"),
    ;

    private static final Map<Integer, UserState> MAP = Arrays.stream(values()).collect(Collectors.toMap(v -> v.id, Function.identity()));
    private final Integer id;
    private final Supplier<String> value;

    public static UserState match(int id) {
        UserState value1 = MAP.get(id);
        return Optional.of(value1).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public static Supplier<String> matchValue(int id) {
        return Optional.of(MAP.get(id).getValue()).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public static UserState match(String value) {
        for (UserState entity : UserState.values()) {
            if (StringUtils.equals(entity.value.get(), value)) {
                return entity;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static Integer matchId(String value) {
        for (UserState entity : UserState.values()) {
            if (StringUtils.equals(entity.value.get(), value)) {
                return entity.id;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
