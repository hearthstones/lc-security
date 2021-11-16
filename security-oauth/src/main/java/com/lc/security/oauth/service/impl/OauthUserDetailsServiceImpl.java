package com.lc.security.oauth.service.impl;

import com.lc.security.oauth.service.OauthUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * OauthUserDetailsServiceImpl
 *
 * @author luchao
 * @date 2021/11/16
 */
@Service("oauthUserDetailsService")
public class OauthUserDetailsServiceImpl implements OauthUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserBySms(String mobile) {

        return null;
    }
}
