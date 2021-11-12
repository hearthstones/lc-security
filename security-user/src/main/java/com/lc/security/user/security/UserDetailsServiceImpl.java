package com.lc.security.user.security;

import com.lc.security.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MyUserDetailsService
 *
 * @author luchao
 * @date 2021/11/8
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.lc.security.user.model.User user = userMapper.selectByUsername(username);
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(),
                user.getEnabled(), user.getAccountNonExpired(), user.getCredentialsNonExpired(), user.getAccountNonLocked(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        log.info("userDetails: {}", userDetails);
        return userDetails;
    }
}
