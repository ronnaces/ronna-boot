package com.ronnaces.ronna.boot.excel.component.servlet;

import com.alibaba.fastjson.JSON;
import com.google.common.net.HttpHeaders;
import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.core.constant.CommonConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.ronnaces.loong.core.constant.CommonConstant.CONTENT_TYPE;
import static com.ronnaces.loong.core.constant.CommonConstant.EXCEL_FORMAT;

/**
 * ServletUtils
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2022-08-15 12:53
 */
public class ServletUtils {

    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }


    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * Renders the string to the client
     *
     * @param response render
     * @param result   result
     */
    public static void renderString(HttpServletResponse response, Result<?> result) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renders the string to the client
     *
     * @param response render
     * @param result   result
     */
    public static void renderString(HttpServletResponse response, String result) {
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renderExcel(HttpServletResponse response, String excelName) {
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String fileName = URLEncoder.encode(excelName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + CommonConstant.PERIOD + EXCEL_FORMAT);
    }

    public static void render(HttpServletResponse response, String contentType, String excelName, String extension) {
        response.setContentType(contentType);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String fileName = URLEncoder.encode(excelName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName + CommonConstant.PERIOD + extension);
    }
}
