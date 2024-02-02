package com.ronnaces.ronna.boot.mqtt.component.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AuthProperties
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/3/2 11:18
 */

@Getter
@Setter
@Component
@ConfigurationProperties(MqttProperties.LOONG_PREFIX)
public class MqttProperties {

    public static final String LOONG_PREFIX = "loong.mqtt";

    /**
     * 服务器地址以及端口
     */
    private String[] serverURIs;

    private String clientId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 心跳时间,默认为5分钟
     * <p>
     * // 设置会话心跳时间 单位为秒 服务器会每隔KeepAliveInterval秒的时间向客户端发送心跳判断客户端是否在线，
     */
    private Integer keepAliveInterval;

    /**
     * 通信质量，详见MQTT协议
     */
    private Integer qos;

    /**
     * 是否重新创建 session
     */
    private Boolean cleanStart;

    /**
     * 是否自动重联，默认为开启自动重联
     */
    private Boolean automaticReconnect;

    private Integer automaticReconnectMinDelay;

    private Integer automaticReconnectMaxDelay;

    /**
     * 消费超时时间
     */
    private Long completionTimeout;

    /**
     * 连接超时,默认为30秒
     */
    private int connectionTimeout;

    /**
     * 恢复间隔
     */
    private int maxReconnectDelay;

    /**
     * 订阅主题
     */
    private String[] topic;

}
