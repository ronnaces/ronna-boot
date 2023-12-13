package com.ronnaces.ronna.boot.system.management.user.converter;

import com.ronnaces.loong.middleware.excel.core.converters.Converter;
import com.ronnaces.loong.middleware.excel.core.converters.ReadConverterContext;
import com.ronnaces.loong.middleware.excel.core.converters.WriteConverterContext;
import com.ronnaces.loong.middleware.excel.core.enums.CellDataTypeEnum;
import com.ronnaces.loong.middleware.excel.core.metadata.data.WriteCellData;
import com.ronnaces.ronna.boot.system.management.user.enums.StateEnum;

/**
 * State Converter
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/7/13 16:45
 */
public class StateConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadConverterContext<?> context) {
        return StateEnum.convert(context.getReadCellData().getStringValue()).getKey();
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {
        return new WriteCellData<>(StateEnum.convert(context.getValue()).getValue());
    }
}