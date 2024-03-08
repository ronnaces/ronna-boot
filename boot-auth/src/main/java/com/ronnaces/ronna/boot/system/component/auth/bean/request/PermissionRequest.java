package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;


@Tag(name = "权限请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequest {

    @Schema(description = "角色ID")
    private String roleId;


    @Schema(description = "权限ID列表")
    private List<String> permissions;

}
