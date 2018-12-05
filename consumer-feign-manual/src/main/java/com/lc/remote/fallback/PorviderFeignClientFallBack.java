package com.lc.remote.fallback;

import com.lc.entity.Provider;
import com.lc.remote.ProviderFeignClient;

import java.util.Map;

/**
 * Created by lenovo on 2018/12/4.
 */
public class PorviderFeignClientFallBack implements ProviderFeignClient {

    @Override
    public Provider getProvider(Long id) {
        return null;
    }

    @Override
    public Provider get1(Long id, String userName) {
        return null;
    }

    @Override
    public Provider get2(Map<String, Object> map) {
        return null;
    }

    @Override
    public Provider post1(Provider provider) {
        return null;
    }
}
