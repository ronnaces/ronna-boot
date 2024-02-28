package com.ronnaces.ronna.boot.system.modules.dict.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 字典表
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
@TableName("system_dict")
@Schema(description = "字典表")
public class SystemDict extends CreateEntity {

    /**
     * 编码
     */
    @Schema(description = "编码")
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 名称
     */
    @Schema(description = "名称")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

}