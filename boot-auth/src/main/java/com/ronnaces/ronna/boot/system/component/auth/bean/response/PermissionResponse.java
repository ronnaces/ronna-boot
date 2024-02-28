package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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
public class PermissionResponse {

    /**
     * 编号
     */
    private String id;

    /**
     * 编码
     */
    private String code;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 标题
     */
    private String title;

    /**
     * 地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排名
     */
    private Integer ranking;

    /**
     * 组件路径
     */
    private String path;

    /**
     * 组件名称
     */
    private String component;

    /**
     * 顶级菜单默认跳转地址
     */
    private String redirect;

    /**
     * 类型: 1-顶级菜单, 2-子菜单, 3-按钮
     */
    private Integer type;

    /**
     * 是否隐藏: 0-否 1-是
     */
    private Boolean whetherHide;

    /**
     * 是否拆分子路由: 0-否 1-是
     */
    private Boolean whetherSplitRoute;

    /**
     * 是否路由: 0-否 1-是
     */
    private Boolean whetherRoute;

    /**
     * 是否叶子节点: 0-否 1-是
     */
    private Boolean whetherLeaf;

    /**
     * 是否缓存: 0-否 1-是
     */
    private Boolean whetherCache;

    /**
     * 是否隐藏Tab: 0-否 1-是
     */
    private Boolean whetherHideTab;


    private List<PermissionResponse> children;

    public static PermissionResponse of(SystemPermission entity) {
        PermissionResponse response = new PermissionResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
