package com.ronnaces.ronna.boot.system.component.authentication.bean.request;

import lombok.*;

import java.util.List;

/**
 * Permission Bind
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
public class PermissionRequest {

    private String roleId;

    /**
     * permissions
     */
    private List<String> permissions;

}
