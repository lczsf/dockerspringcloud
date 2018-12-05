package com.lc.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/12/4.
 */
@EnableAutoConfiguration
@RefreshScope
@RestController
public class DemoCotroller {
    @RequestMapping(path ="/hello", method = RequestMethod.GET)
    public String from() {
        return "hello everyone";
    }
}
