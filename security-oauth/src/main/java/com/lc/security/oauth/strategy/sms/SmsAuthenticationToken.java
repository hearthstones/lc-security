package com.lc.security.oauth.strategy.sms;

import com.lc.security.oauth.pojo.dto.SmsDTO;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * SmsAuthenticationToken
 * <p>
 *  参照 UsernamePasswordAuthenticationToken
 *  @see org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 * </p>
 *
 * @author luchao
 * @date 2021/11/16
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 530L;

    /**
     * 身份
     */
    private final Object principal;

    public SmsAuthenticationToken(SmsDTO params) {
        super(null);
        this.principal = params;
        this.setAuthenticated(false);
    }

    public SmsAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}