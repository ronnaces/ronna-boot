package com.ronnaces.ronna.boot.system.management.user.role.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
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
public class SystemUserRole extends ParentEntity {

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    /**
     * 角色ID
     */
    @ExcelProperty(value = "角色ID")
    @TableField(value = "role_id")
    private String roleId;


}