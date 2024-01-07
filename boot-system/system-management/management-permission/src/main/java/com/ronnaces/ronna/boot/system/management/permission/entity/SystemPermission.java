package com.ronnaces.ronna.boot.system.management.permission.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.core.structure.tree.TreeEntity;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelIgnoreUnannotated;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SystemPermission
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@TableName("system_permission")
public class SystemPermission extends CreateEntity implements TreeEntity<SystemPermission, String>, Serializable {

    /**
     * 编码
     */
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 父级ID
     */
    @ExcelProperty(value = "父级ID")
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    @TableField(value = "url")
    private String url;

    /**
     * 图标
     */
    @ExcelProperty(value = "图标")
    @TableField(value = "icon")
    private String icon;

    /**
     * 排名
     */
    @ExcelProperty(value = "排名")
    @TableField(value = "ranking")
    private Integer ranking;

    /**
     * 组件路径
     */
    @ExcelProperty(value = "组件路径")
    @TableField(value = "path")
    private String path;

    /**
     * 组件名称
     */
    @ExcelProperty(value = "组件名称")
    @TableField(value = "component")
    private String component;

    /**
     * 顶级菜单默认跳转地址
     */
    @ExcelProperty(value = "顶级菜单默认跳转地址")
    @TableField(value = "redirect")
    private String redirect;

    /**
     * 类型: 1-顶级菜单, 2-子菜单, 3-按钮
     */
    @ExcelProperty(value = "类型: 1-顶级菜单, 2-子菜单, 3-按钮")
    @TableField(value = "type")
    private Integer type;

    /**
     * 是否隐藏: 0-否 1-是
     */
    @ExcelProperty(value = "是否隐藏: 0-否 1-是")
    @TableField(value = "whether_hide")
    private Boolean whetherHide;

    /**
     * 是否拆分子路由: 0-否 1-是
     */
    @ExcelProperty(value = "是否拆分子路由: 0-否 1-是")
    @TableField(value = "whether_split_route")
    private Boolean whetherSplitRoute;

    /**
     * 是否路由: 0-否 1-是
     */
    @ExcelProperty(value = "是否路由: 0-否 1-是")
    @TableField(value = "whether_route")
    private Boolean whetherRoute;

    /**
     * 是否叶子节点: 0-否 1-是
     */
    @ExcelProperty(value = "是否叶子节点: 0-否 1-是")
    @TableField(value = "whether_leaf")
    private Boolean whetherLeaf;

    /**
     * 是否缓存: 0-否 1-是
     */
    @ExcelProperty(value = "是否缓存: 0-否 1-是")
    @TableField(value = "whether_cache")
    private Boolean whetherCache;

    /**
     * 是否隐藏Tab: 0-否 1-是
     */
    @ExcelProperty(value = "是否隐藏Tab: 0-否 1-是")
    @TableField(value = "whether_hide_tab")
    private Boolean whetherHideTab;

    @TableField(exist = false)
    private List<SystemPermission> children;

    @Override
    public boolean whetherRoot() {
        return StringUtils.isEmpty(getParentId());
    }

    @Override
    public void initChildren() {
        if (getChildren() == null) {
            this.setChildren(new ArrayList<>());
        }
    }

    @Override
    public void addChildren(SystemPermission child) {
        initChildren();
        getChildren().add(child);
    }

}