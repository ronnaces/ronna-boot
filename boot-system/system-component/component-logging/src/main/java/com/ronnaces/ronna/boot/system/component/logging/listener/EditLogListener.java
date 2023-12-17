package com.ronnaces.ronna.boot.system.component.logging.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ronnaces.loong.autoconfigure.log.aop.AccessLoggerAfterEvent;
import com.ronnaces.loong.autoconfigure.log.aop.AccessLoggerInfo;
import com.ronnaces.ronna.boot.system.component.logging.enums.LoggingType;
import com.ronnaces.ronna.boot.system.management.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.management.login.log.mapper.SystemLoginLogMapper;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.mapper.SystemUserMapper;
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

    private final SystemUserMapper userMapper;

    @Async
    @EventListener
    public void onApplicationEvent(AccessLoggerAfterEvent event) {
        log.debug("[start handle login log event]");
        saveLogging(event.getInfo());
        log.debug("[handle login log event finish]");
    }

    private void saveLogging(AccessLoggerInfo info) {
        Method method = info.getMethod();
        Map<String, Object> parameterMap = info.getParameters();
        StringJoiner methodAppender = new StringJoiner(",", method.getName().concat("("), ")");
        String[] parameterNames = parameterMap.keySet().toArray(new String[0]);
        Class<?>[] parameterTypes = method.getParameterTypes();

        for (int i = 0; i < parameterTypes.length; i++) {
            methodAppender.add(parameterTypes[i]
                    .getSimpleName()
                    .concat(" ")
                    .concat(parameterNames.length > i ? parameterNames[i] : ("arg" + i)));
        }

        Object data = info.getResult().getData();
        String jsonString = JSONObject.toJSONString(data);
        Map<String, Object> map = JSON.parseObject(jsonString, Map.class);
        String username = (String) map.get("username");
        SystemLoginLog entity = new SystemLoginLog();
        SystemUser user = userMapper.findByUsername(username);

        entity.setUserId(user.getId());
        entity.setAgent(info.getHttpHeaders().get("user-agent"));
        entity.setIp(info.getIp());
        entity.setResultCode(info.getResult().getCode());
        entity.setResultMessage(info.getResult().getMessage());
        entity.setType(LoggingType.LOGIN_LOG.getCode());
        loginLogMapper.insert(entity);
    }
}
