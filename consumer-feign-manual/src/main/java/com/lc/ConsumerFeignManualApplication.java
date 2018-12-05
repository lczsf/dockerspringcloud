package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by lenovo on 2018/12/4.
 * http://localhost:8012/hystrix.stream
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
public class ConsumerFeignManualApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignManualApplication.class, args);
    }

}
