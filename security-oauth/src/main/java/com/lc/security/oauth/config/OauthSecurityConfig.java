package com.lc.security.oauth.config;

import com.lc.security.oauth.strategy.sms.SmsAuthenticationSecurityConfig;
import com.lc.security.oauth.strategy.web.WebUsernamePasswordAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * OauthSecurityConfig
 *
 * @author luchao
 * @date 2021/11/12
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService oauthUserDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;
    @Resource
    private WebUsernamePasswordAuthenticationSecurityConfig webUsernamePasswordAuthenticationSecurityConfig;

    /** 不需要认证的路径 */
    private final String[] ignoreUrls = {"/sms/send", "/oauth/app/sms", "/oauth/app/account", "/oauth/web/account", "/oauth/app/current"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(oauthUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 放开权限的url
                .antMatchers(ignoreUrls)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

        // 加载自定义登录
        http.apply(smsAuthenticationSecurityConfig);
        http.apply(webUsernamePasswordAuthenticationSecurityConfig);
    }
}
