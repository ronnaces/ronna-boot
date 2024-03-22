package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronnaces.ronna.boot.system.modules.role.entity.SystemRole;
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
public class RoleResponse {

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
    @Schema(description = "名称")
    private String name;
    @Schema(description = "编号")
    private String code;
    @Schema(description = "状态: 0-禁用 1-正常")
    private Integer status;
    @Schema(description = "描述")
    private String remark;

    public static RoleResponse of(SystemRole entity) {
        RoleResponse response = new RoleResponse();
        BeanUtils.copyProperties(entity, response);
        response.setRemark(entity.getDescription());
        response.setStatus(entity.getWhetherForbid());
        return response;
    }
}