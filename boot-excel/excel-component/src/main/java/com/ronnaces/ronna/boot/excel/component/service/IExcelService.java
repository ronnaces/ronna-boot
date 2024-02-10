package com.ronnaces.ronna.boot.excel.component.service;


import com.ronnaces.ronna.boot.excel.component.bean.request.UpRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * IAppService
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-01-30
 */
public interface IExcelService {
    void download(HttpServletResponse response) throws IOException;

    void upload(MultipartFile file, HttpServletResponse response);

    void up(String holeName, String filename, List<UpRequest> cachedDataList);
}
