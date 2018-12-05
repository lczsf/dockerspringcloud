package com.lc.service;

import com.lc.entity.SysUser;

/**
 * Created by lenovo on 2018/12/3.
 */
public interface UserService {

    SysUser loadByUsername(String username);
}
