package com.ronnaces.ronna.boot.excel.component.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.MapUtils;
import com.ronnaces.loong.common.servlet.ServletUtils;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
 * MqttServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@RequiredArgsConstructor
@Service
public class ExcelServiceImpl implements IExcelService {

    @Override
    public void download(HttpServletResponse response) throws IOException {

        FillData fillData = new FillData();
        fillData.setName("张三");
        fillData.setNumber(5.2);

        ClassPathResource classPathResource = new ClassPathResource("template/simple.xlsx");
        String datetime = "2024-02-04";
        InputStream inputStream = classPathResource.getInputStream();
        ServletUtils.renderExcel(response, "苏地2023-WG-16号地块项目基坑及轨道保护监测日报表" + "2024");
        EasyExcel.write(response.getOutputStream()).withTemplate(inputStream).excelType(ExcelTypeEnum.XLSX).autoCloseStream(Boolean.TRUE).sheet(0).doFill(fillData);
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    public class FillData {
        private String name;
        private double number;
        private Date date;
    }
}

