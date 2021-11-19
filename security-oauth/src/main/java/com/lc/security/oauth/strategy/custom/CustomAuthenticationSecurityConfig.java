package com.lc.security.oauth.strategy.custom;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

import javax.annotation.Resource;

/**
 * 自定义 AuthenticationSecurityConfig 父类
 *
 * @author luchao
 * @date 2021/11/16
 */
public abstract class CustomAuthenticationSecurityConfig<P extends AuthenticationProvider> extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Resource
    private P provider;

    /**
     * 用于实现泛型 P 的注入
     * @return P
     */
    protected abstract P getProvider();

    @Override
    public void configure(HttpSecurity http) {
        http.authenticationProvider(provider);
    }
}
