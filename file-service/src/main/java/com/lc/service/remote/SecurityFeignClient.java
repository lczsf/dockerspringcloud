package com.lc.service.remote;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2018/12/3.
 */
public interface SecurityFeignClient {

    @RequestMapping(value = "/from",method = RequestMethod.GET)
    String sayHello();

}
