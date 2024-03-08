package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.time.LocalDate;


@Tag(name = "编辑个人信息")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {

    @Schema(description = "用户昵称")
    private String name;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "生日")
    @DateTimeFormat("yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate birthday;

    @Schema(description = "性别: 1-未知, 2-男, 3-女")
    private Integer sex;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "电话")
    private String phone;

}
