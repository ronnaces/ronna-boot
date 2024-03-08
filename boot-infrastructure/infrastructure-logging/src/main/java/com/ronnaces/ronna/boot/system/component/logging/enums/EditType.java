package com.ronnaces.ronna.boot.system.component.logging.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EditType {


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
