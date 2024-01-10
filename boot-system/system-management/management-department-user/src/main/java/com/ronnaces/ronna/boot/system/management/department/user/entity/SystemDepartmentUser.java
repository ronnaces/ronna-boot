package com.ronnaces.ronna.boot.system.management.department.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_department_user")
@Schema(description= "部门用户表")
public class SystemDepartmentUser extends ParentEntity {


    /**
     * 部门ID
     */
    @Schema(description = "部门ID")
    @ExcelProperty(value = "部门ID")
    @TableField(value = "department_id")
    private String departmentId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;


}