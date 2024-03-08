package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@Tag(name = "绑定请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BindRequest {

    @NotEmpty(message = "主要编号列表不能为空")
    @Schema(description = "主要编号")
    private String mainId;

    @NotEmpty(message = "次要编号列表不能为空")
    @Schema(description = "次要编号列表")
    private List<String> minorIds;

}
