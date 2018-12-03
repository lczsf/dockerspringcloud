package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by lenovo on 2018/11/28.
 * @EnableCircuitBreaker熔断机制添加
 * /hystrix
 */
@EnableFeignClients
//@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
