package com.ronnaces.ronna.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * main
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023/1/12 15:08
 */
@EnableAsync
@EnableRetry
@EnableAdminServer
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.ronnaces.ronna.boot","com.ronnaces.loong"})
public class EntrypointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrypointApplication.class, args);
    }
}
