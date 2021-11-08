package com.lc.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * BrowserSecurityConfig
 *
 * @author luchao
 * @date 2021/11/8
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
        http.httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }

}
