package com.ronnaces.ronna.boot.system.component.logging.listener;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ronnaces.loong.autoconfigure.log.aop.entity.AccessLoggerInfo;
import com.ronnaces.loong.autoconfigure.log.aop.event.AccessLoggerAfterEvent;
import com.ronnaces.loong.core.time.LocalDateTimeUtil;
import com.ronnaces.ronna.boot.system.component.logging.entity.UserEntity;
import com.ronnaces.ronna.boot.system.component.logging.enums.EditType;
import com.ronnaces.ronna.boot.system.component.logging.enums.LoginType;
import com.ronnaces.ronna.boot.system.modules.edit.log.entity.SystemEditLog;
import com.ronnaces.ronna.boot.system.modules.edit.log.mapper.SystemEditLogMapper;
import com.ronnaces.ronna.boot.system.modules.login.log.entity.SystemLoginLog;
import com.ronnaces.ronna.boot.system.modules.login.log.mapper.SystemLoginLogMapper;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;


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
//        Method method = info.getMethod();
//        Map<String, Object> parameterMap = info.getParameters();
//        StringJoiner methodAppender = new StringJoiner(",", method.getName().concat("("), ")");
//        String[] parameterNames = parameterMap.keySet().toArray(new String[0]);
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        for (int i = 0; i < parameterTypes.length; i++) {
//            methodAppender.add(parameterTypes[i]
//                    .getSimpleName()
//                    .concat(" ")
//                    .concat(parameterNames.length > i ? parameterNames[i] : ("arg" + i)));
//        }

        Object principal = authentication.getPrincipal();
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(principal, user);
        switch (info.getType()) {
            case LOGIN -> {
                if (Objects.nonNull(info.getResult())) {
                    SystemLoginLog entity = new SystemLoginLog();
                    entity.setUserId(user.getId());
                    entity.setAgent(info.getHttpHeaders().get("user-agent"));
                    entity.setIp(info.getIp());
                    entity.setResultCode(info.getResult().getCode());
                    entity.setResultMessage(info.getResult().getMsg());
                    entity.setType(LoginType.USERNAME.getCode());
                    loginLogMapper.insert(entity);
                }
            }
            case EDIT -> {
                SystemEditLog entity = new SystemEditLog();
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
