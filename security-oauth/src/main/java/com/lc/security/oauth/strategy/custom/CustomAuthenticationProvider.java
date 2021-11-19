package com.lc.security.oauth.strategy.custom;

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
 * CustomAuthenticationProvider
 *
 * @author luchao
 * @date 2021/11/16
 */
@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

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
        CustomAuthenticationToken customAuthenticationToken = (CustomAuthenticationToken) authentication;
        String username = (String) customAuthenticationToken.getPrincipal();
        String password = (String) customAuthenticationToken.getCredentials();
        // 获取 UserDetails
        UserDetails user = oauthUserDetailsService.loadWebUserByPrincipal(username);
        if (ObjectUtils.isEmpty(user)) {
            log.error("账号不存在！UserDetails: {}", user);
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.error("密码错误！");
        }
        // 构造 SmsAuthenticationToken
        CustomAuthenticationToken resToken = new CustomAuthenticationToken(user, null, user.getAuthorities());
        resToken.setDetails(customAuthenticationToken.getDetails());
        return resToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
