package com.ronnaces.ronna.boot.system.component.api.interceptor;

import com.alibaba.fastjson2.JSON;
import com.ronnaces.ronna.boot.system.component.api.wapper.SignatureRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;



@Slf4j
public class SignatureInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String method = request.getMethod();
        String accept = request.getHeader("accept");
        String contentType = request.getContentType();
        String date = request.getHeader("x-ca-date");
        String key = request.getHeader("x-ca-key");
        String nonce = request.getHeader("x-ca-nonce");
        String signatureMethod = request.getHeader("x-ca-signature-method");
        String timestamp = request.getHeader("x-ca-timestamp");
        String signatureHeaders = request.getHeader("x-ca-signature-headers");
        String queryString = request.getQueryString();
        String requestURI = request.getRequestURI();

        SignatureRequestWrapper signatureRequestWrapper = new SignatureRequestWrapper(request);
        String jsonParam = signatureRequestWrapper.getBodyString();
        boolean isSuccess = false;

        // todo 待完善
        if (StringUtils.equalsIgnoreCase("post", method)) {
            Map<String, Object> bodyMap = new HashMap<>();
            switch (contentType) {
                case MediaType.APPLICATION_JSON_VALUE:
                    bodyMap = JSON.parseObject(signatureRequestWrapper.getReader(), Map.class);
                    isSuccess = true;
                    break;
                case MediaType.APPLICATION_FORM_URLENCODED_VALUE:
                    String[] split = jsonParam.split("&");
                    for (String s : split) {
                        String[] split1 = s.split("=");
                        bodyMap.put(split1[0], split1[1]);
                    }
                    isSuccess = true;
                    break;
                default:
                    break;
            }
            bodyMap.forEach((k, v) -> log.info("{} = {}", k, v));
        } else {
            isSuccess = true;
        }

        return isSuccess;
    }


}

