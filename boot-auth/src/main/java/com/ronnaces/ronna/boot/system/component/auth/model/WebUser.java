package com.ronnaces.ronna.boot.system.component.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

/**
 * WebLoginUser
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/10 5:26
 */
@Schema(description = "网站登录用户")
@Getter
@Setter
public class WebUser extends User {

    private Set<String> permissionList;

    private String userId;

    private String name;

    private String avatar;

    private Set<String> departmentList;

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<String> permissionList) {
        super(username, password, authorities);
        this.permissionList = permissionList;
    }

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<String> permissionList, String userId) {
        super(username, password, authorities);
        this.permissionList = permissionList;
        this.userId = userId;
    }

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<String> permissionList, String userId, String name) {
        super(username, password, authorities);
        this.permissionList = permissionList;
        this.userId = userId;
        this.name = name;
    }

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<String> permissionList, String userId, String name, String avatar) {
        super(username, password, authorities);
        this.permissionList = permissionList;
        this.userId = userId;
        this.name = name;
        this.avatar = avatar;
    }

    public WebUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Set<String> permissionList, String userId, String name, String avatar, Set<String> departmentList) {
        super(username, password, authorities);
        this.permissionList = permissionList;
        this.userId = userId;
        this.name = name;
        this.avatar = avatar;
        this.departmentList = departmentList;
    }

}
