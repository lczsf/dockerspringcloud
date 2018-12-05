package com.lc.controller;

import com.lc.entity.Provider;
import com.lc.remote.ProviderFeignClient;
import com.lc.remote.ProviderSelfDefineFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lenovo on 2018/12/4.
 */
@RestController
public class GetProviderController {
    @Autowired
    private ProviderFeignClient providerFeignClient;

    @Autowired
    private ProviderSelfDefineFeignClient providerSelfDefineFeignClient;

    @RequestMapping(path ="/getProviderById/{id}", method = RequestMethod.GET)
    public Provider getProviderById(@PathVariable("id") Long id) {
        return providerFeignClient.getProvider(id);
    }
/**
 * 暂时不能混用
 */
//    @RequestMapping(path ="/getSelftProviderById/{id}", method = RequestMethod.GET)
//    public Provider getSelftProviderById(@PathVariable("id") Long id) {
//        return providerSelfDefineFeignClient.getProvider(id);
//    }
}
