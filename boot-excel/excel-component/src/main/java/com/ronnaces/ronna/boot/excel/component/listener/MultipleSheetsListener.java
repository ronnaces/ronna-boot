package com.ronnaces.ronna.boot.excel.component.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson2.JSON;
import com.ronnaces.ronna.boot.excel.component.bean.request.MultipleSheetsData;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Getter
@Setter
public class MultipleSheetsListener extends AnalysisEventListener<MultipleSheetsData> {
    List<MultipleSheetsData> list = new ArrayList<>();

    @Override
    public void invoke(MultipleSheetsData data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.debug("A form is read finished.");
        log.debug("sheet title: {}", list.get(0).getTitle());
        log.debug("All row:{}", JSON.toJSONString(list));
    }

    public List<MultipleSheetsData> getList() {
        return list;
    }

    public void setList(List<MultipleSheetsData> list) {
        this.list = list;
    }
}