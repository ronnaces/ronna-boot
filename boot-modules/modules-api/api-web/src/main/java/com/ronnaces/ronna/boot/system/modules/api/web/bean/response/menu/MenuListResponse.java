package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.menu;

import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Tag(name = "响应参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuListResponse {

    private String id;

    private String parentId;

    @Schema(description = "类型: 1-菜单, 2-iframe, 3-外链, 4-按钮", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer menuType;

    @Schema(description = "路由地址", requiredMode = Schema.RequiredMode.REQUIRED)
    private String path;

    @Schema(description = "路由名称，保持唯一", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    @Schema(description = "组件", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String component;

    @Schema(description = "路由重定向", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String redirect;

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "图标", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String icon;

    @Schema(description = "子路由", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer rank;

    @Schema(description = "菜单名称右侧的额外图标", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String extraIcon;

    @Schema(description = "内嵌的`iframe`链接", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String frameSrc;

    @Schema(description = "子路由", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean isFrameSrcInternal;

    @Schema(description = "是否在菜单中显示", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "true")
    private Boolean showLink;

    @Schema(description = "是否显示父级菜单", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean showParent;

    @Schema(description = "按钮级别权限设置", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String auths;

    @Schema(description = "路由组件缓存", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean keepAlive;

    @Schema(description = "`iframe`页是否开启首次加载动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "true")
    private Boolean frameLoading;

    @Schema(description = "是否不添加信息到标签页", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "false")
    private Boolean hiddenTag;

    @Schema(description = "动态路由可打开的最大数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer dynamicLevel;

    @Schema(description = "将某个菜单激活", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String activePath;

    @Schema(description = "进场动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String enterTransition;

    @Schema(description = "离场动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String leaveTransition;

    public static MenuListResponse from(SystemPermission entity) {
        MenuListResponse response = new MenuListResponse();
        BeanUtils.copyProperties(entity, response);
        response.setMenuType(entity.getType() - 1);
        response.setRank(entity.getRanking());
        response.setFrameSrc(entity.getUrl());
        if (StringUtils.isNotEmpty(entity.getCode())) {
            response.setAuths(entity.getCode());
        }
        if (Objects.nonNull(entity.getWhetherHideParent())) {
            response.setShowParent(!entity.getWhetherHideParent());
        }
        if (Objects.nonNull(entity.getWhetherCache())) {
            response.setKeepAlive(entity.getWhetherCache());
        }
        if (Objects.nonNull(entity.getWhetherHide())) {
            response.setShowLink(!entity.getWhetherHide());
        }
        response.setHiddenTag(false);
        response.setFrameLoading(true);
        return response;
    }
}