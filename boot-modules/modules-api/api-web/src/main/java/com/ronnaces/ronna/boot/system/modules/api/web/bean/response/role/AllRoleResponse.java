package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role;

import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Tag(name = "响应参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllRoleResponse {

    @Schema(description = "编号")
    private String id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "编号")
    private String code;

    public static AllRoleResponse of(SystemRole entity) {
        AllRoleResponse response = new AllRoleResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}