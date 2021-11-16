package com.lc.security.oauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * OauthUserDetailsService
 *
 * @author luchao
 * @date 2021/11/16
 */
public interface OauthUserDetailsService extends UserDetailsService {

    /**
     * 根据 mobile 获取 UserDetails
     *
     * @param mobile 手机号
     * @return UserDetails
     */
    UserDetails loadUserBySms(String mobile);

}
