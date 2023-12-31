package com.ronnaces.ronna.boot.system.management.role.permission.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色权限表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-07-28
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@TableName("system_role_permission")
public class SystemRolePermission extends ParentEntity {

    /**
     * 角色ID
     */
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;

    /**
     * 权限ID
     */
    @ExcelProperty(value = "权限ID")
    @TableField(value = "permission_id")
    private String permissionId;


}