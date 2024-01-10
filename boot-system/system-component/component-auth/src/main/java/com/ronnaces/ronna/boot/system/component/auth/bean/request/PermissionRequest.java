package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;

/**
 * Permission Bind
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "权限请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequest {

    @Schema(description = "角色ID")
    private String roleId;

    /**
     * permissions
     */
    @Schema(description = "权限ID列表")
    private List<String> permissions;

}
