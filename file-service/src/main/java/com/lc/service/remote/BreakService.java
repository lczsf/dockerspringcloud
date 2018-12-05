package com.lc.service.remote;

import com.lc.service.failure.BreakServiceFailure;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2018/11/29.
 */
@FeignClient(value = "FAILER-CLIENT" ,fallback= BreakServiceFailure.class)
public interface BreakService {

    @RequestMapping(value = "/what",method = RequestMethod.GET)
    String what();
}
