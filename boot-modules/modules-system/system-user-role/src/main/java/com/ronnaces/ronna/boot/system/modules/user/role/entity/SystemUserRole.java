package com.ronnaces.ronna.boot.system.modules.user.role.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.ParentEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@TableName("system_user_role")
@Schema(description = "用户角色表")
public class SystemUserRole extends ParentEntity {


    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;


    @Schema(description = "角色ID")
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;


}