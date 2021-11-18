package com.lc.security.oauth.strategy.web;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * WebUsernamePasswordAuthenticationSecurityConfig
 *
 * @author luchao
 * @date 2021/11/16
 */
@Component
public class WebUsernamePasswordAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private WebUsernamePasswordAuthenticationProvider provider;

    @Override
    public void configure(HttpSecurity http) {
        http.authenticationProvider(provider);
    }
}
