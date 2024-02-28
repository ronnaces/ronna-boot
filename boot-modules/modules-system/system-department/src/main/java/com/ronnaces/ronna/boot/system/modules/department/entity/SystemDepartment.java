package com.ronnaces.ronna.boot.system.modules.department.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.core.structure.tree.TreeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_department")
@Schema(description = "部门表")
public class SystemDepartment extends CreateEntity implements TreeEntity<SystemDepartment, String>, Serializable {

    /**
     * 编码
     */
    @Schema(description = "编码")
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 父级ID
     */
    @Schema(description = "父级ID")
    @ExcelProperty(value = "父级ID")
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 名称
     */
    @Schema(description = "名称")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 电话
     */
    @Schema(description = "电话")
    @ExcelProperty(value = "电话")
    @TableField(value = "phone")
    private String phone;

    /**
     * 地址
     */
    @Schema(description = "地址")
    @ExcelProperty(value = "地址")
    @TableField(value = "address")
    private String address;

    /**
     * 排名
     */
    @Schema(description = "排名")
    @ExcelProperty(value = "排名")
    @TableField(value = "ranking")
    private Integer ranking;

    /**
     * 类别: 1-公司, 2-部门, 3-职位
     */
    @Schema(description = "类别: 1-公司, 2-部门, 3-职位")
    @ExcelProperty(value = "类别: 1-公司, 2-部门, 3-职位")
    @TableField(value = "category")
    private Integer category;

    /**
     * 类型: 1-顶级部门, 2-子部门
     */
    @Schema(description = "类型: 1-顶级部门, 2-子部门")
    @ExcelProperty(value = "类型: 1-顶级部门, 2-子部门")
    @TableField(value = "type")
    private Integer type;

    /**
     * 是否禁用: 0-否 1-是
     */
    @Schema(description = "是否禁用: 0-否 1-是")
    @ExcelProperty(value = "是否禁用: 0-否 1-是")
    @TableField(value = "whether_forbid")
    private Boolean whetherForbid;

    @TableField(exist = false)
    private List<SystemDepartment> children;

    @Override
    public boolean whetherRoot() {
        return StringUtils.isEmpty(getParentId());
    }

    @Override
    public void initChildren() {
        if (getChildren() == null) {
            this.setChildren(new ArrayList<>());
        }
    }

    @Override
    public void addChildren(SystemDepartment child) {
        initChildren();
        getChildren().add(child);
    }
}