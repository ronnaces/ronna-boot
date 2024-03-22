package com.ronnaces.ronna.boot.system.modules.api.web.bean.request.dept;

import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
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
public class CreateDeptRequest {

    @Schema(description = "父级ID")
    private String parentId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "部门负责人")
    private String principal;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "排名")
    private Integer sort;

    @Schema(description = "状态: 0-禁用 1-正常")
    private Integer status;

    @Schema(description = "描述")
    private String remark;

    public static SystemDepartment to(CreateDeptRequest request) {
        SystemDepartment entity = new SystemDepartment();
        BeanUtils.copyProperties(request, entity);
        entity.setDescription(request.getRemark());
        entity.setWhetherForbid(request.getStatus());
        entity.setRanking(request.getSort());
        return entity;
    }
}