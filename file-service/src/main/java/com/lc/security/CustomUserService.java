package com.lc.security;

import com.lc.entity.SysRole;
import com.lc.entity.SysUser;
import com.lc.service.local.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/12/3.
 */
@Component
public class CustomUserService implements UserDetailsService {

    protected Logger logger = LoggerFactory.getLogger(CustomUserService.class);
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        try {
            SysUser user = userService.loadByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户名不存在!");
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            //用于添加用户的权限。只要把用户权限添加到authorities。
            for(SysRole role:user.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
                logger.info("loadUserByUsername: " + user);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("loadUserByUsername失败：{}",e);
        }
        throw new UsernameNotFoundException("用户不存在");
    }

}
