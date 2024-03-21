package com.ronnaces.ronna.boot.system.modules.api.web.bean.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Tag(name = "请求参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuIdRequest {

    @Schema(description = "角色编号")
    private String id;

}