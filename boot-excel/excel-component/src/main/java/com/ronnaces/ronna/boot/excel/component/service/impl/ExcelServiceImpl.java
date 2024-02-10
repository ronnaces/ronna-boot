package com.ronnaces.ronna.boot.excel.component.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ronnaces.loong.common.excel.style.ColumnWidthStyleConfig;
import com.ronnaces.loong.common.excel.style.EasyExcelUtils;
import com.ronnaces.loong.common.excel.style.RowHeightStyleConfig;
import com.ronnaces.loong.common.servlet.ServletUtils;
import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import com.ronnaces.ronna.boot.excel.component.bean.response.UpResponse;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * MqttServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ExcelServiceImpl implements IExcelService {

    public static final String TMPDIR = "java.io.tmpdir";

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

    @Override
    public void upload(MultipartFile file, HttpServletResponse response) {
        FillData fillData = new FillData();
        fillData.setName("张三");
        fillData.setNumber(5.2);
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    public class FillData {
        private String name;
        private double number;
        private Date date;
    }

    @Override
    public void up(String holeName, String filename, List<UpRequest> cachedDataList) {
        List<UpResponse> result = new ArrayList<>();
        for (int i = 0; i < cachedDataList.size(); i++) {
            UpResponse upResponse = new UpResponse();
            UpRequest current = cachedDataList.get(i);
            BigDecimal checksum = BigDecimal.valueOf(new Random().nextDouble(1.1) - 0.5);
            checksum = checksum.setScale(1, RoundingMode.DOWN);
            if (checksum.equals(new BigDecimal("0.0"))) {
                checksum = checksum.add(new BigDecimal("0.1"));
            }
            upResponse.setDepth(i + 1 * 0.5);
            upResponse.setChecksum(checksum);
            if (i + 1 < cachedDataList.size()) {
                UpRequest next = cachedDataList.get(i + 1);
                upResponse.setStandard(current.getValue().subtract(next.getValue()));
            } else {
                upResponse.setStandard(current.getValue());
            }
            upResponse.setPipeBottom(current.getValue());
            upResponse.setDispZeroY(upResponse.getStandard().add(upResponse.getChecksum().divide(new BigDecimal(2), RoundingMode.DOWN)));
            upResponse.setDispReversalY(upResponse.getChecksum().divide(new BigDecimal(2), RoundingMode.DOWN).subtract(upResponse.getStandard()));
            if (i == 0) {
                upResponse.setPipeTop(upResponse.getStandard().negate());
            } else {
                UpResponse prev = result.get(i - 1);
                upResponse.setPipeTop(prev.getPipeTop().subtract(upResponse.getStandard()));

            }
            result.add(upResponse);
        }

        String[] split = StringUtils.split(filename, CommonConstant.DASH);
        String dir = StringUtils.joinWith(CommonConstant.DASH, StringUtils.right(split[0], 4), split[1], StringUtils.split(split[2], "（")[0]);
        String parentDir = System.getProperty(TMPDIR) + CommonConstant.SLASH + dir;
        File parentFile = new File(parentDir);
        if (parentFile.mkdirs()) {
            log.debug("多级层文件夹创建成功！创建后的文件目录为：{},上级文件为: {}", parentFile.getPath(), parentFile.getParent());
        }
        String pathname = parentDir + CommonConstant.SLASH + holeName + CommonConstant.PERIOD + CommonConstant.EXCEL_FORMAT;
        File file = new File(pathname);
        EasyExcel.write(file, UpResponse.class)
                .sheet(holeName)
                .registerWriteHandler(new ColumnWidthStyleConfig())
                .registerWriteHandler(new RowHeightStyleConfig())
                .registerWriteHandler(EasyExcelUtils.getStyleStrategy())
                .doWrite(result);
    }
}

