package com.ronnaces.ronna.boot.system.modules.dict.item.entity;

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


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_dict_item")
@Schema(description = "字典项目表")
public class SystemDictItem extends CreateEntity {


    @Schema(description = "字典ID")
    @ExcelProperty(value = "字典ID")
    @TableField(value = "dict_id")
    private Long dictId;


    @Schema(description = "名称")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;


    @Schema(description = "数据值")
    @ExcelProperty(value = "数据值")
    @TableField(value = "text")
    private String text;


    @Schema(description = "排名")
    @ExcelProperty(value = "排名")
    @TableField(value = "ranking")
    private Integer ranking;


    @Schema(description = "是否禁用: 0-禁用 1-启用")
    @ExcelProperty(value = "是否禁用: 0-禁用 1-启用")
    @TableField(value = "whether_forbid")
    private Integer whetherForbid;


}