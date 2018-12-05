package com.lc.service.failure;

import com.lc.service.remote.BreakService;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2018/11/29.
 */
@Component
public class BreakServiceFailure implements BreakService {

    @Override
    public String what() {
        return "sorry,waiting pls......";
    }
}
