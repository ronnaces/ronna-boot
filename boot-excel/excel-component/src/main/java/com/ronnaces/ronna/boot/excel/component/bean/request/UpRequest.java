package com.ronnaces.ronna.boot.excel.component.bean.request;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import java.math.BigDecimal;


@Tag(name = "上传的数据")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpRequest {

    @ExcelProperty(value = "本次测值")
    @Schema(description = "本次测值")
    private BigDecimal value;

}

