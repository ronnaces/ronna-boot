package com.ronnaces.ronna.boot.system.management.department.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门用户表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@TableName("system_department_user")
public class SystemDepartmentUser extends CreateEntity {


    /**
     * 部门ID
     */
    @ExcelProperty(value = "部门ID")
    @TableField(value = "department_id")
    private Long departmentId;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private Long userId;


}