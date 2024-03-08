package com.ronnaces.ronna.boot.system.component.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Schema(description = "网站登录用户")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebUser extends BasicUser {

    private Set<String> permissionList;

    private String userId;

    private String name;

    private String avatar;

    private Set<String> departmentList;
}
