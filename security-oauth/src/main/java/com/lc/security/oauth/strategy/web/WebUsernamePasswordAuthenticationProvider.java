package com.lc.security.oauth.strategy.web;

import com.lc.security.oauth.service.OauthUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * WebUsernamePasswordAuthenticationProvider
 *
 * @author luchao
 * @date 2021/11/16
 */
@Component
@Slf4j
public class WebUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private OauthUserDetailsService oauthUserDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 认证
     *
     * @param authentication 认证参数
     * @return 认证结果
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取 mobile、code
        WebUsernamePasswordAuthenticationToken webUsernamePasswordAuthenticationToken = (WebUsernamePasswordAuthenticationToken) authentication;
        String username = (String) webUsernamePasswordAuthenticationToken.getPrincipal();
        String password = (String) webUsernamePasswordAuthenticationToken.getCredentials();
        // 获取 UserDetails
        UserDetails user = oauthUserDetailsService.loadWebUserByPrincipal(username);
        if (ObjectUtils.isEmpty(user)) {
            log.error("账号不存在！UserDetails: {}", user);
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.error("密码错误！");
        }
        // 构造 SmsAuthenticationToken
        WebUsernamePasswordAuthenticationToken resToken = new WebUsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        resToken.setDetails(webUsernamePasswordAuthenticationToken.getDetails());
        return resToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return WebUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
