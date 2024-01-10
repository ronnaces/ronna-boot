package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;

/**
 * Department Bind
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "部门绑定")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @Schema(description = "用户ID")
    private String userId;

    /**
     * departments
     */
    @Schema(description = "部门列表")
    private List<String> departments;

}
