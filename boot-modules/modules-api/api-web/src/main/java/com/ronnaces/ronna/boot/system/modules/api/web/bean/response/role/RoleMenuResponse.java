package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role;

import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Tag(name = "响应参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuResponse {

    @Schema(description = "编号")
    private String id;

    @Schema(description = "父级编号")
    private String parentId;

    @Schema(description = "类型")
    private Integer menuType;

    @Schema(description = "标题")
    private String title;

    public static RoleMenuResponse of(SystemPermission entity) {
        RoleMenuResponse response = new RoleMenuResponse();
        response.setId(entity.getId());
        response.setParentId(entity.getParentId());
        response.setMenuType(entity.getType());
        response.setTitle(entity.getTitle());
        return response;
    }
}