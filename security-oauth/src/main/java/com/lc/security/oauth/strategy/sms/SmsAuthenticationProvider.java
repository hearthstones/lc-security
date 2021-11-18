package com.lc.security.oauth.strategy.sms;

import com.lc.security.oauth.service.OauthUserDetailsService;
import com.lc.security.oauth.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SmsAuthenticationProvider
 *
 * @author luchao
 * @date 2021/11/16
 */
@Component
@Slf4j
public class SmsAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private OauthUserDetailsService oauthUserDetailsService;
    @Resource
    private SmsUtil smsUtil;

    /**
     * 认证
     *
     * @param authentication 认证参数
     * @return 认证结果
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取 mobile、code
        SmsAuthenticationToken smsAuthenticationToken = (SmsAuthenticationToken) authentication;
        String mobile = (String) smsAuthenticationToken.getPrincipal();
        String code = (String) smsAuthenticationToken.getCredentials();
        // 校验
        smsUtil.check(mobile, code);
        // 获取 UserDetails
        UserDetails user = oauthUserDetailsService.loadUserBySms(mobile);
        if (ObjectUtils.isEmpty(user)) {
            // todo: 异常处理
            log.error("账号不存在！UserDetails: {}", user);
        }
        // 构造 SmsAuthenticationToken
        SmsAuthenticationToken resToken = new SmsAuthenticationToken(user, null, user.getAuthorities());
        resToken.setDetails(smsAuthenticationToken.getDetails());
        return resToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
