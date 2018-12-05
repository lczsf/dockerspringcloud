package com.lc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Created by lenovo on 2018/11/28.
 * @EnableCircuitBreaker熔断机制添加
 * /hystrix
 */
//@EnableFeignClients  验证远程微服务权限暂时取消
//@EnableHystrixDashboard
@EnableDiscoveryClient
@MapperScan("com.lc.mapper")
@SpringBootApplication
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
