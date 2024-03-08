package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(description = "登录角色响应对象")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {


    @Schema(description = "编码")
    private String code;


    @Schema(description = "名称")
    private String name;

}
