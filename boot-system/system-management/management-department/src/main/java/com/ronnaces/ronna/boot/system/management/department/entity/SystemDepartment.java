package com.ronnaces.ronna.boot.system.management.department.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 部门表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@TableName("system_department")
public class SystemDepartment extends CreateEntity {


    /**
     * 编码
     */
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 父级ID
     */
    @ExcelProperty(value = "父级ID")
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 电话
     */
    @ExcelProperty(value = "电话")
    @TableField(value = "phone")
    private String phone;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    @TableField(value = "address")
    private String address;

    /**
     * 排名
     */
    @ExcelProperty(value = "排名")
    @TableField(value = "ranking")
    private Integer ranking;

    /**
     * 类别: 1-公司, 2-部门, 3-职位
     */
    @ExcelProperty(value = "类别: 1-公司, 2-部门, 3-职位")
    @TableField(value = "category")
    private Integer category;

    /**
     * 类型: 1-顶级部门, 2-子部门
     */
    @ExcelProperty(value = "类型: 1-顶级部门, 2-子部门")
    @TableField(value = "type")
    private Integer type;

    /**
     * 是否禁用: 0-否 1-是
     */
    @ExcelProperty(value = "是否禁用: 0-否 1-是")
    @TableField(value = "whether_forbid")
    private Boolean whetherForbid;

    /**
     * 是否删除: 0-否 1-是
     */
    @ExcelProperty(value = "是否删除: 0-否 1-是")
    @TableField(value = "whether_delete")
    private Boolean whetherDelete;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @ExcelProperty(value = "更新人")
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;


}