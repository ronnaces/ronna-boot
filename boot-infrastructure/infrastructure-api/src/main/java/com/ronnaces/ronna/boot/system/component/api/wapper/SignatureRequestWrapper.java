package com.ronnaces.ronna.boot.system.component.api.wapper;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * SignatureRequestWrapper
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 20:48
 */
@Slf4j
public class SignatureRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public SignatureRequestWrapper(HttpServletRequest request) {
        super(request);
        body = getBodyString(request).getBytes(StandardCharsets.UTF_8);
    }

    public String getBodyString(final ServletRequest request) {
        try {
            return getInputString(request.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBodyString() {
        final InputStream inputStream = new ByteArrayInputStream(body);
        return getInputString(inputStream);
    }

    private String getInputString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            log.error("", e);
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            @Override
            public int read() {
                return inputStream.read();
            }

            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }

}

