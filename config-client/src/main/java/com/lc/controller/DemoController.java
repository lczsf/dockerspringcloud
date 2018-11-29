package com.lc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/11/29.
 */
@EnableAutoConfiguration
@RefreshScope
@RestController
public class DemoController {

    @Value("${hello}")
    String from;

    @RequestMapping(path ="/{from}", method = RequestMethod.GET)
    public String from() {
        return this.from;
    }
}
