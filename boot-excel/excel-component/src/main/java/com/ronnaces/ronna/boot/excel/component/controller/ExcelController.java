package com.ronnaces.ronna.boot.excel.component.controller;

import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * EXCEL管理
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@Tag(name = "EXCEL管理")
@Slf4j
@AccessLogger
@RestController
@AllArgsConstructor
@RequestMapping("/v1/excel")
public class ExcelController {

    private final IExcelService service;

    @Operation(summary = "下载模板")
    @PostMapping(value = "/download")
    public void downloadPipe(HttpServletResponse response) throws IOException {
        service.download(response);
    }
}