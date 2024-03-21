package com.ronnaces.ronna.boot.system.modules.api.web.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "调整状态")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditUserStateRequest {

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "用户编号")
    private String id;

}
