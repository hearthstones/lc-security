package com.lc.security.oauth.service.impl;

import com.lc.security.oauth.service.OauthUserDetailsService;
import com.lc.security.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * OauthUserDetailsServiceImpl
 *
 * @author luchao
 * @date 2021/11/16
 */
@Slf4j
@Service("oauthUserDetailsService")
public class OauthUserDetailsServiceImpl implements OauthUserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserBySms(username);
    }

    @Override
    public UserDetails loadUserBySms(String mobile) {
        com.lc.security.user.domain.User user = userMapper.selectByMobile(mobile);
        return getUserDetails(user);
    }

    @Override
    public UserDetails loadWebUserByPrincipal(String principal) {
        com.lc.security.user.domain.User user = userMapper.selectByPrincipal(principal);
        return getUserDetails(user);
    }

    /**
     * 构造 UserDetails
     *
     * @param user 用户信息
     * @return UserDetails
     */
    private UserDetails getUserDetails(com.lc.security.user.domain.User user) {
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(),
                user.getEnabled(), user.getAccountNonExpired(), user.getCredentialsNonExpired(), user.getAccountNonLocked(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
        log.info("userDetails: {}", userDetails);
        return userDetails;
    }
}
