package com.ronnaces.ronna.boot.excel.component.service;


import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * IAppService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface IExcelService {
    void download(HttpServletResponse response) throws IOException;
}
