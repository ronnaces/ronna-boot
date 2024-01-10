package com.ronnaces.ronna.boot.system.management.user.client.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.ParentEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户客户端表
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_user_client")
@Schema(description = "用户客户端表")
public class SystemUserClient extends ParentEntity {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 客户端ID
     */
    @Schema(description = "客户端ID")
    @ExcelProperty(value = "客户端ID")
    @TableField(value = "client_id")
    private Long clientId;

}