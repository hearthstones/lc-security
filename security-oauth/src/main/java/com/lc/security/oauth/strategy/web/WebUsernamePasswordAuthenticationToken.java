package com.lc.security.oauth.strategy.web;

import com.lc.security.oauth.strategy.custom.CustomAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * WebUsernamePasswordAuthenticationToken
 * <p>
 *  CustomAuthenticationToken 模板
 *  @see com.lc.security.oauth.strategy.custom.CustomAuthenticationToken
 * </p>
 *
 * @author luchao
 * @date 2021/11/16
 */
public class WebUsernamePasswordAuthenticationToken extends CustomAuthenticationToken {

    public WebUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public WebUsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}