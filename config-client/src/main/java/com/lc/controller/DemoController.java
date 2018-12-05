package com.lc.controller;

import com.lc.dao.entity.Demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by lenovo on 2018/11/29.
 */
@EnableAutoConfiguration
@RefreshScope
@RestController
public class DemoController {

//    @Value("${hello}") 暂时没有新增这个client的配置文件 参考cloud-config
//    String from;

    @RequestMapping(path ="/from", method = RequestMethod.GET)
    public String from() {
        return "";
    }

    @RequestMapping(path ="/getDemoObj", method = RequestMethod.GET)
    public Demo getDemoObj() {
        return new Demo(1, "chaolee", Calendar.getInstance().getTime());
    }
}
