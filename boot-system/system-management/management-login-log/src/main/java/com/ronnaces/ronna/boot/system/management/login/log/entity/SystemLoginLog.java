package com.ronnaces.ronna.boot.system.management.login.log.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录日志表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@TableName("system_login_log")
public class SystemLoginLog extends ParentEntity {


    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private String userId;

    /**
     * 请求IP
     */
    @ExcelProperty(value = "请求IP")
    @TableField(value = "ip")
    private String ip;

    /**
     * 用户代理
     */
    @ExcelProperty(value = "用户代理")
    @TableField(value = "agent")
    private String agent;

    /**
     * 类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录
     */
    @ExcelProperty(value = "类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录")
    @TableField(value = "type")
    private Integer type;

    /**
     * 响应码
     */
    @ExcelProperty(value = "响应码")
    @TableField(value = "result_code")
    private Integer resultCode;

    /**
     * 响应消息
     */
    @ExcelProperty(value = "响应消息")
    @TableField(value = "result_message")
    private String resultMessage;


}