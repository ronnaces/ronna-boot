package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta implements Serializable {

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "子路由", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String code;

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

    @Schema(description = "页面级别权限设置", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<String> roles;

    @Schema(description = "按钮级别权限设置", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<String> auths;

    @Schema(description = "路由组件缓存", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Boolean keepAlive;

    @Schema(description = "`iframe`页是否开启首次加载动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "true")
    private Boolean frameLoading;

    @Schema(description = "是否不添加信息到标签页", requiredMode = Schema.RequiredMode.NOT_REQUIRED, defaultValue = "false")
    private Boolean hiddenTag;

    @Schema(description = "动态路由可打开的最大数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Integer dynamicLevel;

    @Schema(description = "页面加载动画（两种模式，第二种权重更高，第一种直接采用`vue`内置的`transitions`动画，第二种是使用`animate.css`编写进、离场动画，平台更推荐使用第二种模式，已经内置了`animate.css`，直接写对应的动画名即可）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Transition transition;

    @Schema(description = "将某个菜单激活", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String activePath;

}
