package com.ronnaces.ronna.boot.system.management.login.log.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 登录日志表
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
@TableName("system_login_log")
@Schema(name = "SystemLoginLog", description = "登录日志表")
public class SystemLoginLog extends CreateEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    @Schema(description = "请求IP")
    @ExcelProperty(value = "请求IP")
    @TableField(value = "ip")
    private String ip;

    @Schema(description = "用户代理")
    @ExcelProperty(value = "用户代理")
    @TableField(value = "agent")
    private String agent;

    @Schema(description = "类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录")
    @ExcelProperty(value = "类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录")
    @TableField(value = "type")
    private Integer type;

    @Schema(description = "响应码")
    @ExcelProperty(value = "响应码")
    @TableField(value = "result_code")
    private Integer resultCode;

    @Schema(description = "响应消息")
    @ExcelProperty(value = "响应消息")
    @TableField(value = "result_message")
    private String resultMessage;

}