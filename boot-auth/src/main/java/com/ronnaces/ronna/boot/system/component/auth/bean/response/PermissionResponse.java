package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.ronna.boot.system.modules.permission.entity.SystemPermission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PermissionResponse {

    
    private String id;

    
    private String code;

    
    private String parentId;

    
    private String name;

    
    private String title;

    
    private String url;

    
    private String icon;

    
    private Integer ranking;

    
    private String path;

    
    private String component;

    
    private String redirect;

    
    private Integer type;

    
    private Boolean whetherHide;

    
    private Boolean whetherSplitRoute;

    
    private Boolean whetherRoute;

    
    private Boolean whetherLeaf;

    
    private Boolean whetherCache;

    
    private Boolean whetherHideTab;


    private List<PermissionResponse> children;

    public static PermissionResponse of(SystemPermission entity) {
        PermissionResponse response = new PermissionResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
