package com.ronnaces.ronna.boot.mqtt.component.conponent;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "outboundChannel")
public interface MqttGateway {
    /**
     * 定义重载方法，用于消息发送
     *
     * @param payload
     */
    void sendToMqtt(String payload);

    /**
     * 指定topic进行消息发送
     *
     * @param topic
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    /**
     * 指定topic进行消息发送
     *
     * @param topic
     * @param qos
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);

    /**
     * 指定topic和消息保留时间进行消息发送
     *
     * @param topic
     * @param qos
     * @param messageExpiryInterval
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, @Header(MqttHeaders.MESSAGE_EXPIRY_INTERVAL) int messageExpiryInterval, String payload);


    /**
     * 指定topic进行消息发送
     *
     * @param topic
     * @param qos
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, byte[] payload);
}

