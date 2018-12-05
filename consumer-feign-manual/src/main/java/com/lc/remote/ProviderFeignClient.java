package com.lc.remote;

import com.lc.entity.Provider;
import com.lc.remote.fallback.PorviderFeignClientFallBack;
import feign.Client;
import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lenovo on 2018/12/4.
 */
@FeignClient(name="provider" ,fallback = PorviderFeignClientFallBack.class)
public interface ProviderFeignClient {

    @RequestMapping(value = "/provider/{id}",method = RequestMethod.GET)
    Provider getProvider(@PathVariable("id") Long id);

    /**
     * Get请求1
     * @param id
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get1",method = RequestMethod.GET)
    Provider get1(@RequestParam("id") Long id,@RequestParam("username") String userName);

    @RequestMapping(value = "/get2",method = RequestMethod.GET)
    Provider get2(@RequestParam Map<String,Object> map);

    /**
     * post请求
     */
    @RequestMapping(value = "/post1",method = RequestMethod.POST)
    Provider post1(@RequestBody Provider provider);

}
