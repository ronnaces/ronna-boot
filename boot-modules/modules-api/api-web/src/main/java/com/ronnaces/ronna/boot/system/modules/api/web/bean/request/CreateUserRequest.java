package com.ronnaces.ronna.boot.system.modules.api.web.bean.request;

import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
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
public class CreateUserRequest {

    @Schema(description = "部门编号")
    private String parentId;

    @Schema(description = "用户编号")
    private String name;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "性别: 1-未知, 2-男, 3-女")
    private Integer sex;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "状态: 1-正常, 2-禁用")
    private Integer status;

    @Schema(description = "描述")
    private String remark;

    public static SystemUser to (CreateUserRequest request) {
        SystemUser entity = new SystemUser();
        BeanUtils.copyProperties(request, entity);
        entity.setState(request.getStatus());
        entity.setDescription(request.getRemark());
        return entity;
    }
}