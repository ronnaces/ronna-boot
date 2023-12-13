package com.ronnaces.ronna.boot.exception;

import com.ronnaces.loong.common.controller.Result;
import com.ronnaces.loong.common.exception.LoongStudioException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * GlobalExceptionHandler
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2022-08-15 12:53
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoongStudioException.class)
    public Result<?> handleLoongStudioException(LoongStudioException e) {
        log.error(e.getMessage(), e);
        if (Objects.isNull(e.getCode()) && StringUtils.isEmpty(e.getMessage())) {
            return Result.fail();
        }
        if (Objects.isNull(e.getCode())) {
            return Result.fail(e.getMessage());
        }

        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public Result<?> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error(e.getMessage(), e);
        if (StringUtils.isEmpty(e.getMessage())) {
            return Result.fail();
        }
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> handleAccessDeniedException(AccessDeniedException e) {
        log.error(e.getMessage(), e);
        if (StringUtils.isEmpty(e.getMessage())) {
            return Result.fail();
        }
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(JwtException.class)
    public Result<?> handleJwtException(JwtException e) {
        log.error(e.getMessage(), e);
        if (StringUtils.isEmpty(e.getMessage())) {
            return Result.fail();
        }
        return Result.fail(e.getMessage());
    }
}
