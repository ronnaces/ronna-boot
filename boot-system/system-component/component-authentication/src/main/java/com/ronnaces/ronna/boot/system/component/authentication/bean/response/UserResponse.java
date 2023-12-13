package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * UserInfo
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 账号
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别: 1-未知, 2-男, 3-女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 角色列表
     */
    private List<String> roles;


}
