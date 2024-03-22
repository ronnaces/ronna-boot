package com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role;

import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Tag(name = "请求参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditRoleRequest {

    @Schema(description = "编号")
    private String id;

    @Schema(description = "部门编号")
    private String code;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String remark;

    public static SystemRole to(EditRoleRequest request, SystemRole entity) {
        BeanUtils.copyProperties(request, entity);
        entity.setDescription(request.getRemark());
        return entity;
    }
}