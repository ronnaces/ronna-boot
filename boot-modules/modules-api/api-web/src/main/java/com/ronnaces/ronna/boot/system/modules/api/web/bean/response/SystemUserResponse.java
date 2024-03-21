package com.ronnaces.ronna.boot.system.modules.api.web.bean.response;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Tag(name = "响应参数")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserResponse {

    @Schema(description = "用户ID")
    private String id;

    @Schema(description = "用户名称")
    private String name;

    @Schema(description = "账号")
    private String username;

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

    @Schema(description = "状态: 1-正常, 2-锁定, 3-禁用")
    private Integer status;

    @Schema(description = "部门")
    private Dept dept;

    @Schema(description = "描述")
    private String remark;

    @Schema(description = "创建时间")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    protected LocalDateTime createTime;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dept {

        @Schema(description = "名称")
        private String name;

        @Schema(description = "编号")
        private String id;

    }

}