package com.lc.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lenovo on 2018/12/4.
 */
//@Configuration
public class FeignConfiguration {

    /**
     * 原生的默认契约 ，为了使用feign自带注解
     * @return
     */
//    @Bean
//    public Contract feignContract(){
//        return new feign.Contract.Default();
//    }
}
