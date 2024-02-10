package com.ronnaces.ronna.boot.excel.component.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import com.ronnaces.ronna.boot.excel.component.listener.ExcelOriginListener;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @Operation(summary = "上传")
    @PostMapping({"/upload"})
    public Result<?> upload(@RequestPart("file") MultipartFile file) throws IOException {
//        for (MultipartFile file : files) {
            analysis(file);
//        }

        return Result.success();
    }

    private void analysis(MultipartFile file) throws IOException {
        ExcelReader excelReader;
        String fileName = file.getOriginalFilename();
        excelReader = EasyExcel.read(file.getInputStream(), UpRequest.class, new ExcelOriginListener<UpRequest>(service, fileName)).headRowNumber(10).build();
        for (ReadSheet readSheet : excelReader.excelExecutor().sheetList()) {
            String sheetName = readSheet.getSheetName();
            Integer sheetNo = readSheet.getSheetNo();
            if (StringUtils.startsWith(sheetName, "CX")) {
                log.debug("sheet name: {}, sheet no: {}", sheetName, sheetNo);
                excelReader.read(readSheet);
            }
        }
        excelReader.finish();
    }
}