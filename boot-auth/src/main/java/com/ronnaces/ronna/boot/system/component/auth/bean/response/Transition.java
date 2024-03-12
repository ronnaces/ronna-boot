package com.ronnaces.ronna.boot.system.component.auth.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Transition implements Serializable {

    @Schema(description = "当前路由动画效果", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    @Schema(description = "进场动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String enterTransition;

    @Schema(description = "离场动画", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String leaveTransition;

}
