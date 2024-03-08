package com.ronnaces.ronna.boot.mqtt.component.service;


import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;


public interface IMqttService {


    void sendToMqtt(String data);


    void sendToMqtt(@Header(MqttHeaders.QOS) Integer qos, String data);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String data);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) Integer qos, String data);


    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic,
                    @Header(MqttHeaders.RESPONSE_TOPIC) String responseTopic,
                    @Header(MqttHeaders.CORRELATION_DATA) String correlationData,
                    @Header(MqttHeaders.QOS) Integer qos,
                    String data);
}
