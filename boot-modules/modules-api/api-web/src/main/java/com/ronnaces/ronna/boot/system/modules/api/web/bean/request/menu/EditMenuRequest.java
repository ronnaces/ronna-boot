package com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu;

import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
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
public class EditMenuRequest {

    @Schema(description = "编号")
    private String id;

    @Schema(description = "部门编号")
    private String code;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String remark;

    public static SystemPermission to(EditMenuRequest request, SystemPermission entity) {
        BeanUtils.copyProperties(request, entity);
        entity.setDescription(request.getRemark());
        return entity;
    }
}