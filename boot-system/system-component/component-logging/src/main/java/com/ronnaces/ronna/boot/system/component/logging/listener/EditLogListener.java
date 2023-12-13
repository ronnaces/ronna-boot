package com.ronnaces.ronna.boot.system.component.logging.listener;

import com.ronnaces.loong.autoconfigure.logging.entity.AccessLoggerInfo;
import com.ronnaces.loong.autoconfigure.logging.events.AccessLoggerEvent;
import com.ronnaces.ronna.boot.system.component.logging.enums.LoggingType;
import com.ronnaces.ronna.boot.system.management.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.management.login.log.mapper.SystemLoginLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.StringJoiner;

/**
 * EditLogListener
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/14 14:44
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class EditLogListener {

    private final SystemLoginLogMapper loginLogMapper;

    @Async
    @EventListener
    public void onApplicationEvent(AccessLoggerEvent event) {
        log.debug("[start handle login log event]");
        saveLogging(event.getInfo());
        log.debug("[handle login log event finish]");
    }

    private void saveLogging(AccessLoggerInfo info) {
        Method method = info.getMethod();
        Map<String, Object> parameterMap = info.getParameterMap();
        StringJoiner methodAppender = new StringJoiner(",", method.getName().concat("("), ")");
        String[] parameterNames = parameterMap.keySet().toArray(new String[0]);
        Class<?>[] parameterTypes = method.getParameterTypes();

        for (int i = 0; i < parameterTypes.length; i++) {
            methodAppender.add(parameterTypes[i]
                    .getSimpleName()
                    .concat(" ")
                    .concat(parameterNames.length > i ? parameterNames[i] : ("arg" + i)));
        }

        SystemLoginLog entity = new SystemLoginLog();
//        entity.setUserId();
//        entity.setAgent();
        entity.setIp(info.getIp());
//        entity.setResultCode();
//        entity.setResultMessage();
        entity.setType(LoggingType.EDIT_LOG.getCode());
        loginLogMapper.insert(entity);
    }
}
