package com.ronnaces.ronna.boot.excel.component.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.ronnaces.loong.common.entity.R;
import com.ronnaces.loong.core.annotation.AccessLogger;
import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import com.ronnaces.ronna.boot.excel.component.listener.ExcelOriginListener;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;


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
    public R<?> upload(@RequestPart("file") MultipartFile file) throws IOException {
//        for (MultipartFile file : files) {
        analysis(file);
//        }

        return R.ok();
    }


    @Operation(summary = "上传")
    @PostMapping({"/up/as"})
    public R<?> upAs(@RequestParam("filepath") String filepath) throws IOException {
        log.debug("[start upload.]");
        Collection<File> files = FileUtils.listFiles(new File(filepath), FileFilterUtils.or(new SuffixFileFilter("xlsm")), DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            analysis(file);
        }
        log.debug("[finish upload.]");
        return R.ok();
    }

    @Operation(summary = "上传")
    @PostMapping({"/ups"})
    public R<?> ups(@RequestParam("files") MultipartFile[] files) throws IOException {
        log.debug("[start upload.]");
        for (MultipartFile file : files) {
            log.debug("[file: {}]", file.getName());
            analysis(file);
        }
        log.debug("[finish upload.]");
        return R.ok();
    }

    @Operation(summary = "上传")
    @PostMapping({"/up"})
    public R<?> up(@RequestPart("file") MultipartFile file) throws IOException {
        log.debug("[start upload.]");
        analysis(file);
        log.debug("[finish upload.]");
        return R.ok();
    }

    private void analysis(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        log.debug("[start {}.]", fileName);
        try (ExcelReader excelReader = EasyExcel.read(file.getInputStream(), UpRequest.class, new ExcelOriginListener<UpRequest>(service, fileName)).headRowNumber(10).build()) {
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
        log.debug("[finish {}.]", fileName);
    }

    private void analysis(File file) throws IOException {
        String fileName = file.getName();
        log.debug("[start {}.]", fileName);
        try (ExcelReader excelReader = EasyExcel.read(new FileInputStream(file), UpRequest.class, new ExcelOriginListener<UpRequest>(service, fileName)).headRowNumber(10).build()) {
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
        log.debug("[finish {}.]", fileName);
    }
}