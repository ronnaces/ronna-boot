package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "修改密码对象")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {


    @Schema(description = "用户名")
    private String username;


    @Schema(description = "旧密码")
    private String oldPassword;


    @Schema(description = "新密码")
    private String password;

}
