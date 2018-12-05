package com.lc.remote;

import com.lc.entity.Provider;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by lenovo on 2018/12/4.
 */
@FeignClient(name="provider")
public interface ProviderFeignClient {

    @RequestMapping(value = "/provider/{id}",method = RequestMethod.GET)
    Provider getProvider(@PathVariable("id") Long id);
}
