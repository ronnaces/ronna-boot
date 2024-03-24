package com.ronnaces.ronna.boot.system.modules.api.web.bean.request.menu;

import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Tag(name = "请求参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMenuRequest {

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

    public static SystemPermission to(CreateMenuRequest request) {
        SystemPermission entity = new SystemPermission();
        entity.setParentId(request.getParentId());
        entity.setType(request.getMenuType() + 1);
        entity.setRanking(request.getRank());
        entity.setTitle(request.getTitle());
        entity.setWhetherHideParent(!request.getShowParent());
        switch (request.menuType + 1) {
            case 1:
                entity.setName(request.getName());
                entity.setPath(request.getPath());
                entity.setComponent(request.getComponent());
                entity.setRedirect(request.getRedirect());
                entity.setIcon(request.getIcon());
                entity.setWhetherHide(!request.getShowLink());
                entity.setWhetherCache(request.getKeepAlive());
                entity.setWhetherRoute(true);
                break;
            case 2:
                entity.setName(request.getName());
                entity.setPath(request.getPath());
                entity.setIcon(request.getIcon());
                entity.setUrl(request.getFrameSrc());
                entity.setWhetherHide(!request.getShowLink());
                entity.setWhetherCache(request.getKeepAlive());
                entity.setWhetherRoute(true);
                break;
            case 3:
                entity.setName(request.getName());
                entity.setPath(request.getPath());
                entity.setIcon(request.getIcon());
                entity.setWhetherHide(!request.getShowLink());
                entity.setWhetherRoute(true);
                break;
            case 4:
                entity.setCode(request.getAuths());
                entity.setWhetherRoute(false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + request.menuType + 1);
        }
        return entity;
    }
}