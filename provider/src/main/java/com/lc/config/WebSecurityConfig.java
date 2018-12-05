package com.lc.config;

import com.lc.security.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by lenovo on 2018/12/4.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    private CustomUserService userService;
    /**
     * 配置密码加密方式（MD5）
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(this.passwordEncoder());
//                new PasswordEncoder() {
//
//            /**
//             * 加密方法
//             * @param rawPassword
//             * @return
//             */
//            public String encode(CharSequence rawPassword) {
//                return MD5Util.string2MD5((String) rawPassword, null);
//            }
//
//            /**
//             * 匹配方法
//             * @param rawPassword 原始字符
//             * @param encodedPassword 已加密字符
//             * @return
//             */
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return encodedPassword.equals(MD5Util.string2MD5((String) rawPassword,null));
//            }
//        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        http.authorizeRequests()
            .anyRequest().authenticated()
            .antMatchers("/login.html", "/**/**.css", "/images/**", "**/**.js", "/index").permitAll()//解决静态资源被拦截的问题
            .antMatchers("/user/**").access("hasRole('USER')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .and().formLogin().loginPage("/login.html").defaultSuccessUrl("/welcome").permitAll()
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/denied");
        http.csrf().disable();//禁用CSRF
    }
}
