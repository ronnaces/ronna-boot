package com.ronnaces.ronna.boot.system.management.dict.item.entity;

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
 * 字典项目表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@TableName("system_dict_item")
public class SystemDictItem extends CreateEntity {


    /**
     * 字典ID
     */
    @ExcelProperty(value = "字典ID")
    @TableField(value = "dict_id")
    private Long dictId;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 数据值
     */
    @ExcelProperty(value = "数据值")
    @TableField(value = "text")
    private String text;

    /**
     * 排名
     */
    @ExcelProperty(value = "排名")
    @TableField(value = "ranking")
    private Integer ranking;

    /**
     * 是否禁用: 0-禁用 1-启用
     */
    @ExcelProperty(value = "是否禁用: 0-禁用 1-启用")
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