package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.dept;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronnaces.ronna.boot.system.modules.department.entity.SystemDepartment;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Tag(name = "响应参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptResponse {

    @Schema(description = "创建时间")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime updateTime;

    @Schema(description = "编号")
    private String id;

    @Schema(description = "父级ID")
    private String parentId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "部门负责人")
    private String principal;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "排名")
    private Integer sort;

    @Schema(description = "类别: 1-公司, 2-部门, 3-职位")
    private Integer category;

    @Schema(description = "类型: 1-顶级部门, 2-子部门")
    private Integer type;

    @Schema(description = "状态: 0-禁用 1-正常")
    private Integer status;

    @Schema(description = "描述")
    private String remark;

    public static DeptResponse of(SystemDepartment entity) {
        DeptResponse response = new DeptResponse();
        BeanUtils.copyProperties(entity, response);
        response.setSort(entity.getRanking());
        response.setRemark(entity.getDescription());
        response.setStatus(entity.getWhetherForbid());
        return response;
    }
}