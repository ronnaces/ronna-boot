package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.loong.core.structure.tree.TreeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Router implements TreeEntity<Router, String> {

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String parentId;

    @Schema(description = "路由地址", requiredMode = Schema.RequiredMode.REQUIRED)
    private String path;

    @Schema(description = "路由名称，保持唯一", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    @Schema(description = "组件", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String component;

    @Schema(description = "路由重定向", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String redirect;

    @Schema(description = "自定义元数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private Meta meta;

    @Schema(description = "子路由", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private List<Router> children;

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
    public void addChildren(Router child) {
        initChildren();
        getChildren().add(child);
    }
}
