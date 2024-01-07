package com.ronnaces.ronna.boot.system.management.role.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * SystemRole
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_role")
public class SystemRole extends CreateEntity {

    /**
     * 编码
     */
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

}