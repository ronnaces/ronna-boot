package com.ronnaces.ronna.boot.system.modules.oauth2.refresh.token.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_oauth2_refresh_token")
@Schema(description = "Oauth2刷新Token表")
public class SystemOauth2RefreshToken extends BaseEntity {


    @Schema(description = "客户端ID")
    @ExcelProperty(value = "客户端ID")
    @TableField(value = "registered_client_id")
    private String registeredClientId;


    @Schema(description = "授权类型")
    @ExcelProperty(value = "授权类型")
    @TableField(value = "authorization_grant_type")
    private String authorizationGrantType;


    @Schema(description = "属性")
    @ExcelProperty(value = "属性")
    @TableField(value = "attributes")
    private String attributes;


    @Schema(description = "状态")
    @ExcelProperty(value = "状态")
    @TableField(value = "state")
    private String state;


    @Schema(description = "访问Token")
    @ExcelProperty(value = "访问Token")
    @TableField(value = "access_token_value")
    private String accessTokenValue;


    @Schema(description = "访问Token发布时间")
    @ExcelProperty(value = "访问Token发布时间")
    @TableField(value = "access_token_issued_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime accessTokenIssuedAt;


    @Schema(description = "访问Token过期时间")
    @ExcelProperty(value = "访问Token过期时间")
    @TableField(value = "access_token_expires_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime accessTokenExpiresAt;


    @Schema(description = "访问Token元数据")
    @ExcelProperty(value = "访问Token元数据")
    @TableField(value = "access_token_metadata")
    private String accessTokenMetadata;


    @Schema(description = "访问Token类型")
    @ExcelProperty(value = "访问Token类型")
    @TableField(value = "access_token_type")
    private String accessTokenType;


    @Schema(description = "访问Token范围")
    @ExcelProperty(value = "访问Token范围")
    @TableField(value = "access_token_scopes")
    private String accessTokenScopes;


    @Schema(description = "刷新Token")
    @ExcelProperty(value = "刷新Token")
    @TableField(value = "refresh_token_value")
    private String refreshTokenValue;


    @Schema(description = "刷新Token发布时间")
    @ExcelProperty(value = "刷新Token发布时间")
    @TableField(value = "refresh_token_issued_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime refreshTokenIssuedAt;


    @Schema(description = "刷新Token过期时间")
    @ExcelProperty(value = "刷新Token过期时间")
    @TableField(value = "refresh_token_expires_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime refreshTokenExpiresAt;


    @Schema(description = "刷新Token元数据")
    @ExcelProperty(value = "刷新Token元数据")
    @TableField(value = "refresh_token_metadata")
    private String refreshTokenMetadata;


}