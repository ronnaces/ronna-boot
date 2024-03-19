package com.ronnaces.ronna.boot.system.modules.user.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Tag(name = "请求参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserRequest {

    @Schema(description = "部门编号")
    private String deptId;

}