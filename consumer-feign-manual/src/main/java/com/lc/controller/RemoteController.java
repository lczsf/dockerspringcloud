package com.lc.controller;

import com.lc.remote.ProviderFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2018/12/4.
 */
public class RemoteController {

    /**
     * 远程需要权限验证的客户端
     * @param decoder
     * @param encoder
     * @param client
     * @param contract
     */
    protected ProviderFeignClient providerFeignClient;

    @Autowired
    public RemoteController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.providerFeignClient= Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                                       .requestInterceptor(new BasicAuthRequestInterceptor("zhangsan", "123"))
                                       .target(ProviderFeignClient.class,"http://provider/");
    }
}
