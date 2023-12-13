package com.ronnaces.ronna.boot.system.management.permission.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ronnaces.loong.common.entity.CreateEntity;
import com.ronnaces.loong.core.structure.tree.TreeNode;
import com.ronnaces.loong.middleware.excel.core.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
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
@TableName("system_permission")
public class SystemPermission extends CreateEntity implements TreeNode<String>, Serializable {

    /**
     * 父级ID
     */
    @ExcelProperty(value = "父级ID")
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 路径
     */
    @ExcelProperty(value = "路径")
    @TableField(value = "path")
    private String path;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    @TableField(value = "name")
    private String name;

    /**
     * 编码
     */
    @ExcelProperty(value = "编码")
    @TableField(value = "code")
    private String code;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    /**
     * 组件
     */
    @ExcelProperty(value = "组件")
    @TableField(value = "component")
    private String component;

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
     * 顶级菜单默认跳转地址
     */
    @ExcelProperty(value = "顶级菜单默认跳转地址")
    @TableField(value = "redirect")
    private String redirect;

    /**
     * 内嵌地址
     */
    @ExcelProperty(value = "内嵌地址")
    @TableField(value = "iframe_url")
    private String iframeUrl;

    /**
     * 类型: 1-顶级菜单, 2-子菜单, 3-按钮
     */
    @ExcelProperty(value = "类型: 1-顶级菜单, 2-子菜单, 3-按钮")
    @TableField(value = "type")
    private Integer type;

    /**
     * 状态: 1-正常, 2-禁用
     */
    @ExcelProperty(value = "状态: 1-正常, 2-禁用")
    @TableField(value = "state")
    private Integer state;

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
    public String id() {
        return this.id;
    }

    @Override
    public String parentId() {
        return this.parentId;
    }

    @Override
    public boolean root() {
        return StringUtils.isEmpty(parentId);
    }

    @Override
    public List<? extends TreeNode<String>> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

}