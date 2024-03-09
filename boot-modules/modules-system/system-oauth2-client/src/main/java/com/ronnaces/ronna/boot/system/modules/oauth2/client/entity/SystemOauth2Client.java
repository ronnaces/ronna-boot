package com.ronnaces.ronna.boot.system.modules.oauth2.client.entity;

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
@TableName("system_oauth2_client")
@Schema(description = "OAuth2客户端表")
public class SystemOauth2Client extends BaseEntity {


    @Schema(description = "客户端ID")
    @ExcelProperty(value = "客户端ID")
    @TableField(value = "client_id")
    private String clientId;


    @Schema(description = "客户端名称")
    @ExcelProperty(value = "客户端名称")
    @TableField(value = "client_name")
    private String clientName;


    @Schema(description = "客户端认证方法")
    @ExcelProperty(value = "客户端认证方法")
    @TableField(value = "client_authentication_methods")
    private String clientAuthenticationMethods;


    @Schema(description = "授权类型")
    @ExcelProperty(value = "授权类型")
    @TableField(value = "authorization_grant_types")
    private String authorizationGrantTypes;


    @Schema(description = "客户端密钥")
    @ExcelProperty(value = "客户端密钥")
    @TableField(value = "client_secret")
    private String clientSecret;


    @Schema(description = "回调URL")
    @ExcelProperty(value = "回调URL")
    @TableField(value = "redirect_uris")
    private String redirectUris;


    @Schema(description = "注销回调URL")
    @ExcelProperty(value = "注销回调URL")
    @TableField(value = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;


    @Schema(description = "授权范围")
    @ExcelProperty(value = "授权范围")
    @TableField(value = "scopes")
    private String scopes;


    @Schema(description = "客户端设置")
    @ExcelProperty(value = "客户端设置")
    @TableField(value = "client_settings")
    private String clientSettings;


    @Schema(description = "token设置")
    @ExcelProperty(value = "token设置")
    @TableField(value = "token_settings")
    private String tokenSettings;


    @Schema(description = "客户端发布时间")
    @ExcelProperty(value = "客户端发布时间")
    @TableField(value = "client_id_issued_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime clientIdIssuedAt;


    @Schema(description = "客户端密钥过期时间")
    @ExcelProperty(value = "客户端密钥过期时间")
    @TableField(value = "client_secret_expires_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime clientSecretExpiresAt;


}