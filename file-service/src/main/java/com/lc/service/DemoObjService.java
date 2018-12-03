package com.lc.service;

import com.lc.service.failure.DemoObjServiceFailure;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2018/11/29.
 * 一般来讲同一个服务应该放在同一个service下
 */
@FeignClient(value = "CONFIG-CLIENT" ,fallback= DemoObjServiceFailure.class)
public interface DemoObjService {
    /**
     * 服务调用
     * 默认情况下使用的是JDK原生的URLConnection发送HTTP请求.没有连接池
     * @return
     */
    @RequestMapping(value = "/from",method = RequestMethod.GET)
    String sayHello();

    @RequestMapping(value = "/getDemoObj",method = RequestMethod.GET)
    String getDemoObj();

}
