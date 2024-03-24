package com.ronnaces.ronna.boot.system.modules.api.web.bean.response.user;

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
public class DepartmentResponse implements TreeEntity<DepartmentResponse, String>, Serializable {


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

    private List<DepartmentResponse> children;

    @Override
    public boolean whetherRoot() {
        return StringUtils.isEmpty(getParentId()) || StringUtils.equals("0", getParentId());
    }

    @Override
    public void initChildren() {
        if (getChildren() == null) {
            this.setChildren(new ArrayList<>());
        }
    }

    @Override
    public void addChildren(DepartmentResponse child) {
        initChildren();
        getChildren().add(child);
    }
}