package com.ronnaces.ronna.boot.system.modules.api.web.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.core.structure.tree.TreeEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Department implements TreeEntity<Department, String>, Serializable {


    private String id;


    private String parentId;


    private String code;


    private String name;


    private String phone;


    private String address;


    private Integer ranking;


    private Integer category;


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
