package com.ronnaces.ronna.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;


//@IntegrationComponentScan
@EnableAsync
@EnableRetry
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.ronnaces.ronna.boot", "com.ronnaces.loong"})
public class EntrypointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrypointApplication.class, args);
    }
}
