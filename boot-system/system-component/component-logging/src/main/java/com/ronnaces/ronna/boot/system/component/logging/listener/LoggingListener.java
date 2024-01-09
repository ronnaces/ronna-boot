package com.ronnaces.ronna.boot.system.component.logging.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ronnaces.loong.autoconfigure.log.aop.entity.AccessLoggerInfo;
import com.ronnaces.loong.autoconfigure.log.aop.event.AccessLoggerAfterEvent;
import com.ronnaces.loong.core.time.LocalDateTimeUtil;
import com.ronnaces.ronna.boot.system.component.logging.enums.EditType;
import com.ronnaces.ronna.boot.system.component.logging.enums.LoginType;
import com.ronnaces.ronna.boot.system.management.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.management.edit.log.mapper.SystemEditLogMapper;
import com.ronnaces.ronna.boot.system.management.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.management.login.log.mapper.SystemLoginLogMapper;
import com.ronnaces.ronna.boot.system.management.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.management.user.mapper.SystemUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
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
public class LoggingListener {

    private final SystemLoginLogMapper loginLogMapper;

    private final SystemEditLogMapper editLogMapper;

    private final SystemUserMapper userMapper;


    @EventListener
    public void onApplicationEvent(AccessLoggerAfterEvent event) {
        log.debug("[start handle login log event]");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        saveLogging(authentication, event.getInfo());
        log.debug("[handle login log event finish]");
    }

    @Async
    void saveLogging(Authentication authentication, AccessLoggerInfo info) {
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

        switch (info.getType()) {
            case LOGIN -> {
                if (Objects.nonNull(info.getResult())) {
                    Object data = info.getResult().getResult();
                    String jsonString = JSONObject.toJSONString(data);
                    Map<String, Object> map = JSON.parseObject(jsonString, Map.class);
                    String userId = (String) map.get("userId");

                    SystemLoginLog entity = new SystemLoginLog();
                    SystemUser user = userMapper.selectById(userId);
                    entity.setUserId(user.getId());
                    entity.setAgent(info.getHttpHeaders().get("user-agent"));
                    entity.setIp(info.getIp());
                    entity.setResultCode(info.getResult().getCode());
                    entity.setResultMessage(info.getResult().getMessage());
                    entity.setType(LoginType.USERNAME.getCode());
                    loginLogMapper.insert(entity);
                }
            }
            case EDIT -> {
                SystemEditLog entity = new SystemEditLog();
                SystemUser user = userMapper.findByUsername((String) authentication.getPrincipal());
                entity.setUserId(user.getId());
                entity.setName(info.getAction());
                entity.setMethod(info.getHttpMethod());
                entity.setUrl(info.getUrl());
                entity.setIp(info.getIp());
                entity.setAgent(info.getHttpHeaders().get("user-agent"));
                entity.setRequestTime(info.getRequestTime());
                entity.setDuration(LocalDateTimeUtil.getEpochMilli(info.getResponseTime()) - LocalDateTimeUtil.getEpochMilli(info.getRequestTime()));
                entity.setType(EditType.match(info.getHttpMethod()));
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(info.getParameters()));
                JSONObject payload = jsonObject.getJSONObject("payload");
                if (Objects.nonNull(payload)) {
                    entity.setParam(payload.toString());
                } else {
                    entity.setParam(jsonObject.toJSONString());
                }
                entity.setResultCode(info.getResult().getCode());
                editLogMapper.insert(entity);
            }
        }
    }
}
