package com.lc.service.failure;

import com.lc.service.DemoObjService;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2018/11/29.
 */
@Component
public class DemoObjServiceFailure implements DemoObjService {

    @Override
    public String sayHello() {
        return "sorry,waiting pls......";
    }

    @Override
    public String getDemoObj() {
        return "sorry,waiting pls......";
    }

}
