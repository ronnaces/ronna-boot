package com.ronnaces.ronna.boot.excel.component.bean.response;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.math.BigDecimal;

/**
 * 上传的数据
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/2/11 17:54
 */
@Tag(name = "上传的数据")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpResponse {

    @ExcelProperty(value = "Depth")
    @Schema(description = "Depth")
    private Double depth;

    @ExcelProperty(value = "A0")
    @Schema(description = "A0")
    private BigDecimal dispZeroY;

    @ExcelProperty(value = "A180")
    @Schema(description = "A180")
    private BigDecimal dispReversalY;

    @Schema(description = "校验和")
    @ExcelProperty(value = "A0+A180")
    private BigDecimal checksum;

    @Schema(description = "标准差")
    @ExcelProperty(value = "(A0-A180)/2")
    private BigDecimal standard;

    @Schema(description = "管型值(profile, 管底起算)")
    @ExcelProperty(value = "Profile")
    private BigDecimal pipeBottom;

    @Schema(description = "管型值(profileK, 管口起算)")
    @ExcelProperty(value = "ProfileK")
    private BigDecimal pipeTop;

}

