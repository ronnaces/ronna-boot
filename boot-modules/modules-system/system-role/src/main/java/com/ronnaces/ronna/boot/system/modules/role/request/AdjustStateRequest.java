package com.ronnaces.ronna.boot.system.modules.role.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "调整状态")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustStateRequest {

    @Schema(description = "状态")
    private Integer state;

    @Schema(description = "用户编号")
    private String id;

}
