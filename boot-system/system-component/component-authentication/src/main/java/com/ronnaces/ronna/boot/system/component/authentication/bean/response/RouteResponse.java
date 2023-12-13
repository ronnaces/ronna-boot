package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * PermissionTree
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteResponse {

    /**
     * ID
     */
    private String id;

    /**
     * 路径
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 组件
     */
    private String component;

    /**
     * 跳转地址
     */
    private String redirect;

    private MetaResponse metaResponse;

    private List<RouteResponse> children;
}
