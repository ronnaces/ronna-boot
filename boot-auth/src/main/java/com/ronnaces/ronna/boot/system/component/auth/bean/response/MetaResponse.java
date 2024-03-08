package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MetaResponse {


    private String title;


    private String code;


    private String icon;


    private String extraIcon;


    private String frameSrc;


    private Boolean showLink;


    private Boolean showParent;


    private List<String> roles;


    private List<String> auths;


    private Boolean keepAlive;


    private Boolean alwaysShow;


    private Integer rank;
}
