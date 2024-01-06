package com.ronnaces.ronna.boot.system.component.authentication.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Meta
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MetaResponse {

    /**
     * title
     */
    private String title;

    /**
     * code
     */
    private String code;

    /**
     * 名称
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
     * 设置该路由进入的权限，支持多个权限叠加
     */
    private List<String> roles;

    /**
     * 按钮级别权限设置
     */
    private List<String> auths;

    /**
     * 路由组件缓存（开启 `true`、关闭 `false`）-可选
     */
    private Boolean keepAlive;

    /**
     * 当一个路由下面的 children 声明的路由大于 1 个时，自动会变成嵌套的模式，
     * 只有一个时，会将那个子路由当做根路由显示在侧边栏，
     * 若想不管路由下面的 children 声明的个数都显示你的根路由，
     * 可以设置 alwaysShow: true，这样就会忽略之前定义的规则，一直显示根路由
     */
    private Boolean alwaysShow;

    /**
     * 排序
     */
    private Integer rank;
}
