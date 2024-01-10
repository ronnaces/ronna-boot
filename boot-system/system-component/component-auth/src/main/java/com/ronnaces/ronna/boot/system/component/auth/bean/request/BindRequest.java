package com.ronnaces.ronna.boot.system.component.auth.bean.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.util.List;

/**
 * Bind Request
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "绑定请求")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BindRequest {

    @Schema(description = "主要ID")
    private String mainId;

    /**
     * minorIds
     */
    @Schema(description = "次要ID列表")
    private List<String> minorIds;

}
