package com.ronnaces.ronna.boot.excel.component.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import com.ronnaces.ronna.boot.excel.component.service.IExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Slf4j
public class ExcelOriginListener<T> implements ReadListener<T> {

    private static final int BATCH_COUNT = 300;

    private final IExcelService service;

    private final String filename;

    private String holeName;

    private List<UpRequest> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    public ExcelOriginListener(IExcelService service, String filename) {
        this.service = service;
        this.filename = filename;
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        UpRequest up = (UpRequest) data;
        if (Objects.isNull(up.getValue()) || up.getValue().equals(new BigDecimal(0))) {
            return;
        }
        String sheetName = context.readSheetHolder().getSheetName();
        log.debug("sheet data: {}", JSON.toJSONString(data));
        if (StringUtils.isNoneBlank(holeName) && !StringUtils.equals(sheetName, holeName)) {
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
        cachedDataList.add(up);
        holeName = sheetName;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {
        service.up(holeName, filename, cachedDataList);
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        ReadListener.super.invokeHead(headMap, context);
    }
}