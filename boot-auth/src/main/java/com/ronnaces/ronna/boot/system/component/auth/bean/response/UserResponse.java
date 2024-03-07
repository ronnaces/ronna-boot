package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * UserInfo
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse implements Serializable {

    @Schema(description = "角色信息")
    private Set<String> roles;

    @Schema(description = "权限信息")
    private Set<String> permissions;

    @Schema(description = "用户id")
    private String userId;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "头像")
    private String avatar;

    public Set<String> toPerm(Collection<GrantedAuthority> authorities) {
        authorities.forEach(s -> permissions.add(String.valueOf(s)));
        return this.permissions;
    }

    public static UserResponse of(SystemUser user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }
}
