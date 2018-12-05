package com.lc.controller;

import com.lc.entity.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lenovo on 2018/12/4.
 */
@RestController
public class DemoCotroller {

    private static final Logger LOGGER= LoggerFactory.getLogger(DemoCotroller.class);

    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public Provider from(@PathVariable("id") Long id) {
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user=(UserDetails)principal;
            Collection<?extends GrantedAuthority> collection=user.getAuthorities();
            for(GrantedAuthority c:collection){
                LOGGER.info("当前用户：{} 当前角色：{}",user.getUsername(),c.getAuthority());
            }
        }
        Provider provider = new Provider();
        provider.setName("hello ,i am provider ,number is :" + id);
        return provider;
    }

    @RequestMapping(path = "/get1",method = RequestMethod.GET)
    public Provider get1(@RequestParam("id") Long id, @RequestParam("username") String userName){
        Provider provider = new Provider();
        provider.setName("hello ,i am provider ,number is :" + id+"name is:"+userName);
        return provider;
    }

    @RequestMapping(path = "/get2",method = RequestMethod.GET)
    Provider get2(@RequestParam Map<String,Object> map){
        Provider provider = new Provider();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            String id=entry.getKey();
            String userName=entry.getValue().toString();
            provider.setName("hello ,i am provider ,number is :" +id+"name is:"+userName);
        }
        return provider;
    }

    /**
     * post请求
     */
    @RequestMapping(value = "/post1",method = RequestMethod.POST)
    Provider post1(@RequestBody Provider provider){
        return provider;
    }
}
