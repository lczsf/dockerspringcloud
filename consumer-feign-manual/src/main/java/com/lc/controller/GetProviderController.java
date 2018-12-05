package com.lc.controller;

import com.lc.entity.Provider;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Client;
import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/12/4.
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class GetProviderController extends RemoteController {

    /**
     * 如果存在远程调用，则实现此构造方法
     * @param decoder
     * @param encoder
     * @param client
     * @param contract
     */
    @Autowired
    public GetProviderController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        super(decoder,encoder,client,contract);
    }

    /**
     * 可以提取到base中返回同一失败参数
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallBack")
    @RequestMapping(path ="/getProviderById/{id}", method = RequestMethod.GET)
    public Provider getProviderById(@PathVariable("id") Long id) {
        return providerFeignClient.getProvider(id);
    }

    public Provider helloFallBack(Long id){
        Provider provider=new Provider();
        provider.setName("failed");
        return provider;
    }

    /**
     * Get请求1http://localhost:8012/get1?id=1&&username=1
     * @param id
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get1",method = RequestMethod.GET)
    Provider get1(@RequestParam("id") Long id, @RequestParam("username") String userName){
        return providerFeignClient.get1(id,userName);
    }

    /**
     * http://localhost:8012/get2/1/username=1
     * @param id
     * @param userName
     * @return
     */
    @RequestMapping(value = "/get2/{id}/{username}",method = RequestMethod.GET)
    Provider get2(@PathVariable("id") Long id, @PathVariable("username") String userName){
        Map map=new HashMap();
        map.put(id.toString(),userName);
        return providerFeignClient.get2(map);
    }

    /**
     * post请求http://localhost:8012/post1/1/username=1
     */
    @RequestMapping(value = "/post1/{id}/{username}",method = RequestMethod.GET)
    Provider post1(@PathVariable("id") Long id, @PathVariable("username") String userName){
        Provider provider=new Provider();
        provider.setName(id+userName);
        return providerFeignClient.post1(provider);
    }

/**
 * 暂时不能混用
 */
//    @RequestMapping(path ="/getSelftProviderById/{id}", method = RequestMethod.GET)
//    public Provider getSelftProviderById(@PathVariable("id") Long id) {
//        return providerSelfDefineFeignClient.getProvider(id);
//    }
}
