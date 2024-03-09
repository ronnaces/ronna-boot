package com.ronnaces.ronna.boot.excel.component.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ronnaces.loong.common.excel.style.ColumnWidthStyleConfig;
import com.ronnaces.loong.common.excel.style.EasyExcelUtils;
import com.ronnaces.loong.common.excel.style.RowHeightStyleConfig;
import com.ronnaces.loong.core.constant.CommonConstant;
import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import com.ronnaces.ronna.boot.excel.component.bean.response.UpResponse;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import com.ronnaces.ronna.boot.excel.component.servlet.ServletUtils;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Service
@Slf4j
public class ExcelServiceImpl implements IExcelService {

    public static final String TMPDIR = "java.io.tmpdir";

    private static BigDecimal format(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (obj.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal("0.00");
        } else if (obj.compareTo(BigDecimal.ZERO) > 0 && obj.compareTo(new BigDecimal(1)) < 0) {
            return new BigDecimal("0" + df.format(obj));
        } else if (obj.compareTo(BigDecimal.ZERO) < 0 && obj.compareTo(new BigDecimal(-1)) > 0) {
            df = new DecimalFormat("0.00");
            return new BigDecimal(df.format(obj));
        } else {
            return new BigDecimal(df.format(obj));
        }
    }

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

    @Override
    public void up(String holeName, String filename, List<UpRequest> cachedDataList) {
        List<UpResponse> result = new ArrayList<>();
        for (int i = 0; i < cachedDataList.size(); i++) {
            UpResponse UpResponse = new UpResponse();
            UpRequest current = cachedDataList.get(i);
            BigDecimal checksum = BigDecimal.valueOf(new Random().nextDouble(1.1) - 0.5);
            UpResponse.setDepth(i * 0.5 + 0.5);
            UpResponse.setChecksum(format(checksum));
            if (i + 1 < cachedDataList.size()) {
                UpRequest next = cachedDataList.get(i + 1);
                UpResponse.setStandard(format(current.getValue().subtract(next.getValue())));
            } else {
                UpResponse.setStandard(format(current.getValue()));
            }
            UpResponse.setPipeBottom(format(current.getValue()));
            BigDecimal zeroY = UpResponse.getStandard().add(UpResponse.getChecksum().divide(new BigDecimal(2), RoundingMode.DOWN));
            UpResponse.setDispZeroY(format(zeroY));
//            BigDecimal dispReversalY = UpResponse.getChecksum().divide(new BigDecimal(2), RoundingMode.DOWN).subtract(UpResponse.getStandard());
            UpResponse.setDispReversalY(format(checksum.subtract(zeroY)));
            if (i == 0) {
                UpResponse.setPipeTop(format(UpResponse.getStandard().negate()));
            } else {
                UpResponse prev = result.get(i - 1);
                UpResponse.setPipeTop(format(prev.getPipeTop().subtract(UpResponse.getStandard())));
            }
            result.add(UpResponse);
        }

        String[] split = StringUtils.split(filename, CommonConstant.DASH);
        String dir = StringUtils.joinWith(CommonConstant.DASH, StringUtils.right(split[0], 4), split[1], StringUtils.split(split[2], "（")[0]);
        String parentDir = System.getProperty(TMPDIR) + CommonConstant.SLASH + "/survey_transform" + CommonConstant.SLASH + dir;
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
                .registerWriteHandler(EasyExcelUtils.getStyleStrategy("等线", false, (short) 11))
                .doWrite(result);
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

