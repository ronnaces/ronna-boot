package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;


@Tag(name = "角色绑定对象")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {

    @Schema(description = "用户ID")
    private String userId;


    @Schema(description = "角色ID列表")
    private List<String> roles;

}
