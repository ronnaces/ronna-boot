package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;


@Tag(name = "部门绑定")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @Schema(description = "用户ID")
    private String userId;

    
    @Schema(description = "部门列表")
    private List<String> departments;

}
