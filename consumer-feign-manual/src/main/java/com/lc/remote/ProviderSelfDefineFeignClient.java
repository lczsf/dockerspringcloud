package com.lc.remote;

import com.lc.config.FeignConfiguration;
import com.lc.entity.Provider;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by lenovo on 2018/12/4.
 */
@FeignClient(name = "provider", configuration = FeignConfiguration.class)
public interface ProviderSelfDefineFeignClient {

//    /**
//     * RequestLine  Feign自定义注解
//     * @param id
//     * @return
//     */
//    @RequestLine(value = "/provider/{id}")
//    Provider getProvider(@PathVariable("id") Long id);
}
