package com.ronnaces.ronna.boot.system.modules.user.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.ronna.boot.system.modules.user.converter.GenderConverter;
import com.ronnaces.ronna.boot.system.modules.user.converter.StateConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_user")
@Schema(description = "用户表")
public class SystemUser extends CreateEntity {


    @Schema(description = "用户ID")
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;


    @Schema(description = "账号")
    @ExcelProperty(value = "账号")
    @TableField(value = "username")
    private String username;


    @Schema(description = "密码")
    @TableField(value = "password")
    private String password;


    @Schema(description = "MD5密码盐")
    @TableField(value = "salt")
    private String salt;


    @Schema(description = "头像")
    @TableField(value = "avatar")
    private String avatar;


    @Schema(description = "生日")
    @ExcelProperty(value = "生日")
    @DateTimeFormat("yyyy-MM-dd")
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;


    @Schema(description = "性别: 1-未知, 2-男, 3-女")
    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    @TableField(value = "sex")
    private Integer sex;


    @Schema(description = "邮箱")
    @ExcelProperty(value = "邮箱")
    @TableField(value = "email")
    private String email;


    @Schema(description = "电话")
    @ExcelProperty(value = "电话")
    @TableField(value = "phone")
    private String phone;


    @Schema(description = "状态: 1-正常, 2-锁定, 3-禁用")
    @ExcelProperty(value = "状态", converter = StateConverter.class)
    @TableField(value = "state")
    private Integer state;

    @Schema(description = "是否禁用: 0-否 1-是")
    @ExcelProperty(value = "是否禁用: 0-否 1-是")
    @TableField(value = "whether_forbid")
    private Integer whetherForbid;
}