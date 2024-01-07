package com.ronnaces.ronna.boot.system.component.auth.bean.response;

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
     * 角色列表
     */
    private List<LoginRoleResponse> roles;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 名称
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 介绍
     */
    private String desc;

}
