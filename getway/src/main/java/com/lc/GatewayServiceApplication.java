package com.lc;

import com.lc.fallback.ConfigClientFallback;
import com.lc.filter.DemoFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by lenovo on 2018/11/30.
 *
 * http://localhost:8080/config-client/from
 * http://localhost:8080/${service-id}/${path}进行转发服务
 * */
@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public DemoFilter demoFilter(){
        return new DemoFilter();
    }

    /**
     * 只会服务时效时生效，如果是地址不对等情况，不会走此失败方法
     * @return
     */
    @Bean
    public ConfigClientFallback configClientFallback(){
        return new ConfigClientFallback();
    }
}
