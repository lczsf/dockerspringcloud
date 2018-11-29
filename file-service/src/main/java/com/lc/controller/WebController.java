package com.lc.controller;

import com.lc.service.BreakService;
import com.lc.service.DemoObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/11/29.
 */
@RestController
public class WebController {
//
//    @Autowired
//    private HelloService helloService;

    @Autowired
    private DemoObjService demoObjService;

    @Autowired
    private BreakService breakService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return demoObjService.sayHello();
    }

    @RequestMapping(value = "/getDemoObj", method = RequestMethod.GET)
    public String getDemoObj() {
        return demoObjService.getDemoObj();
    }

    @RequestMapping(value = "/what", method = RequestMethod.GET)
    public String what() {
        return breakService.what();
    }
}
