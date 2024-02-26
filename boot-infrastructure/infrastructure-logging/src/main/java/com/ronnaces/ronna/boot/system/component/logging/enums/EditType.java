package com.ronnaces.ronna.boot.system.component.logging.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * EditType
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/18 20:36
 */
@Getter
@AllArgsConstructor
public enum EditType {

    /**
     * 类型: 1-新增, 2-修改, 3-删除
     */
    ADDED(1),
    EDIT(2),
    REMOVE(3),
    ;

    private final int code;

    public static int match(String value) {
        switch (value) {
            case "PUT" -> {
                return EditType.EDIT.code;
            }
            case "POST" -> {
                return EditType.ADDED.code;
            }
            case "DELETE" -> {
                return EditType.REMOVE.code;
            }
        }
        return EditType.ADDED.code;
    }
}
