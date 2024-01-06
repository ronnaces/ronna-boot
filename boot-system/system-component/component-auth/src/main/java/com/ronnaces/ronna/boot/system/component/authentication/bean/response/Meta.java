package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Meta
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta implements Serializable {

    /**
     * title
     */
    private String title;

    /**
     * code
     */
    private String code;

    /**
     * 图标
     */
    private String icon;

    /**
     * 名称
     */
    private String extraIcon;

    /**
     * 内嵌的`iframe`链接 `可选`
     */
    private String frameSrc;

    /**
     * 是否在菜单中显示（默认`true`）
     */
    private Boolean showLink;

    /**
     * 是否显示父级菜单-可选
     */
    private Boolean showParent;

    /**
     * 路由组件缓存（开启 `true`、关闭 `false`）-可选
     */
    private Boolean keepAlive;

    /**
     * 隐藏菜单子路由
     */
    private Boolean hideChildrenInMenu;
}
