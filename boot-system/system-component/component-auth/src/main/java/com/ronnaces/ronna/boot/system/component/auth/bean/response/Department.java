package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.core.structure.tree.TreeEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Department
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/19 9:49
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Department implements TreeEntity<Department, String>, Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * parent id
     */
    private String parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 排名
     */
    private Integer ranking;

    /**
     * 类别: 1-公司, 2-部门, 3-职位
     */
    private Integer category;

    /**
     * 类型: 1-顶级部门, 2-子部门
     */
    private Integer type;

    private LocalDateTime createTime;

    private String description;

    private List<Department> children;

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
    public void addChildren(Department child) {
        initChildren();
        getChildren().add(child);
    }
}
