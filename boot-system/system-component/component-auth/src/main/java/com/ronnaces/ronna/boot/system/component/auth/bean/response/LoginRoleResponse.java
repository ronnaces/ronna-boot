package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Login
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRoleResponse {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

}
