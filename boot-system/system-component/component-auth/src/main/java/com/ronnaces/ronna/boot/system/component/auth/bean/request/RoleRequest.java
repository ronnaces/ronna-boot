package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import lombok.*;

import java.util.List;

/**
 * RoleBind
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
public class RoleRequest {

    private String userId;

    /**
     * roles
     */
    private List<String> roles;

}
