package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteResponse {


    private String id;


    private String path;


    private String name;


    private String component;


    private String redirect;

    private MetaResponse meta;

    private List<RouteResponse> children;
}
