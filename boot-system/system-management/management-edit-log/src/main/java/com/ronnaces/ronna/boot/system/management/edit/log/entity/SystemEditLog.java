package com.ronnaces.ronna.boot.system.management.edit.log.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 操作日志表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2024-01-10
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_edit_log")
@Schema(description = "操作日志表")
public class SystemEditLog extends ParentEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    @Schema(description = "名称")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "请求方法")
    @ExcelProperty(value = "请求方法")
    @TableField(value = "method")
    private String method;

    @Schema(description = "请求路径")
    @ExcelProperty(value = "请求路径")
    @TableField(value = "url")
    private String url;

    @Schema(description = "请求IP")
    @ExcelProperty(value = "请求IP")
    @TableField(value = "ip")
    private String ip;

    @Schema(description = "用户代理")
    @ExcelProperty(value = "用户代理")
    @TableField(value = "agent")
    private String agent;

    @Schema(description = "请求时间")
    @ExcelProperty(value = "请求时间")
    @TableField(value = "request_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime requestTime;

    @Schema(description = "耗时")
    @ExcelProperty(value = "耗时")
    @TableField(value = "duration")
    private Long duration;

    @Schema(description = "类型: 1-新增, 2-修改, 3-删除")
    @ExcelProperty(value = "类型: 1-新增, 2-修改, 3-删除")
    @TableField(value = "type")
    private Integer type;

    @Schema(description = "请求参数")
    @ExcelProperty(value = "请求参数")
    @TableField(value = "param")
    private String param;

    @Schema(description = "响应码")
    @ExcelProperty(value = "响应码")
    @TableField(value = "result_code")
    private Integer resultCode;

}