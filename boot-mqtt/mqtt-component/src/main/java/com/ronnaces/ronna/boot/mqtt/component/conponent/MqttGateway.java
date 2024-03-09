package com.ronnaces.ronna.boot.mqtt.component.conponent;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "outboundChannel")
public interface MqttGateway {

    void sendToMqtt(String payload);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, @Header(MqttHeaders.MESSAGE_EXPIRY_INTERVAL) int messageExpiryInterval, String payload);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, byte[] payload);
}

