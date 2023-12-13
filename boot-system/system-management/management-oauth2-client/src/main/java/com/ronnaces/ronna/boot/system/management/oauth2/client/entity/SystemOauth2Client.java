package com.ronnaces.ronna.boot.system.management.oauth2.client.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ronnaces.loong.common.entity.BaseEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * OAuth2 Client
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-11-21
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@TableName("system_oauth2_client")
public class SystemOauth2Client extends BaseEntity {

    /**
     * 客户端ID
     */
    @ExcelProperty(value = "客户端ID")
    @TableField(value = "client_id")
    private String clientId;

    /**
     * 客户端名称
     */
    @ExcelProperty(value = "客户端名称")
    @TableField(value = "client_name")
    private String clientName;

    /**
     * 客户端认证方法
     */
    @ExcelProperty(value = "客户端认证方法")
    @TableField(value = "client_authentication_methods")
    private String clientAuthenticationMethods;

    /**
     * 授权类型
     */
    @ExcelProperty(value = "授权类型")
    @TableField(value = "authorization_grant_types")
    private String authorizationGrantTypes;

    /**
     * 客户端密钥
     */
    @ExcelProperty(value = "客户端密钥")
    @TableField(value = "client_secret")
    private String clientSecret;

    /**
     * 回调URL
     */
    @ExcelProperty(value = "回调URL")
    @TableField(value = "redirect_uris")
    private String redirectUris;

    /**
     * 注销回调URL
     */
    @ExcelProperty(value = "注销回调URL")
    @TableField(value = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;

    /**
     * 授权范围
     */
    @ExcelProperty(value = "授权范围")
    @TableField(value = "scopes")
    private String scopes;

    /**
     * 客户端设置
     */
    @ExcelProperty(value = "客户端设置")
    @TableField(value = "client_settings")
    private String clientSettings;

    /**
     * token设置
     */
    @ExcelProperty(value = "token设置")
    @TableField(value = "token_settings")
    private String tokenSettings;

    /**
     * 客户端发布时间
     */
    @ExcelProperty(value = "客户端发布时间")
    @TableField(value = "client_id_issued_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime clientIdIssuedAt;

    /**
     * 客户端密钥过期时间
     */
    @ExcelProperty(value = "客户端密钥过期时间")
    @TableField(value = "client_secret_expires_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime clientSecretExpiresAt;


}