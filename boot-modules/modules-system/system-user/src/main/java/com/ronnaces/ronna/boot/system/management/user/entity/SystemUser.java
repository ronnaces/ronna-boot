package com.ronnaces.ronna.boot.system.modules.user.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ronnaces.ronna.boot.system.modules.user.converter.GenderConverter;
import com.ronnaces.ronna.boot.system.modules.user.converter.StateConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * SystemUser
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-29
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_user")
@Schema(description = "用户表")
public class SystemUser extends CreateEntity {

    /**
     * 名称
     */
    @Schema(description = "用户ID")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 账号
     */
    @Schema(description = "账号")
    @ExcelProperty(value = "账号")
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField(value = "password")
    private String password;

    /**
     * MD5密码盐
     */
    @Schema(description = "MD5密码盐")
    @TableField(value = "salt")
    private String salt;

    /**
     * 头像
     */
    @Schema(description = "头像")
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 生日
     */
    @Schema(description = "生日")
    @ExcelProperty(value = "生日")
    @DateTimeFormat("yyyy-MM-dd")
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;

    /**
     * 性别: 1-未知, 2-男, 3-女
     */
    @Schema(description = "性别: 1-未知, 2-男, 3-女")
    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @ExcelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;

    /**
     * 电话
     */
    @Schema(description = "电话")
    @ExcelProperty(value = "电话")
    @TableField(value = "phone")
    private String phone;

    /**
     * 状态: 1-正常, 2-锁定, 3-禁用
     */
    @Schema(description = "状态: 1-正常, 2-锁定, 3-禁用")
    @ExcelProperty(value = "状态", converter = StateConverter.class)
    @TableField(value = "state")
    private Integer state;
}