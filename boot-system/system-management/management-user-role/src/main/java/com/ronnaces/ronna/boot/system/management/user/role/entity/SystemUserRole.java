package com.ronnaces.ronna.boot.system.management.user.role.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.ParentEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户角色表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-27
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@TableName("system_user_role")
@Schema(description = "用户角色表")
public class SystemUserRole extends ParentEntity {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;


}