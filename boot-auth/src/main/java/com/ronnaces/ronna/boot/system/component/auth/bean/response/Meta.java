package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta implements Serializable {

    private String title;

    private String code;

    private String icon;

    private Integer rank;

    private String extraIcon;

    private String frameSrc;

    private Boolean isFrameSrcInternal;

    private Boolean showLink;

    private Boolean showParent;

    private List<String> roles;

    private String permission;

    private Boolean hideChildrenInMenu;

    private Boolean keepAlive;

    private Boolean frameLoading;

    private Boolean hiddenTag;

    private Integer dynamicLevel;

    private Transition transition;

}
