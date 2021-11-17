package com.lc.security.user.service.impl;

import com.lc.security.user.mapper.UserMapper;
import com.lc.security.user.model.User;
import com.lc.security.user.pojo.dto.UserDTO;
import com.lc.security.user.pojo.vo.UserVO;
import com.lc.security.user.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author luchao
 * @date 2021/11/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void add(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()))
                .setClearText(dto.getPassword())
                .setEnabled(true)
                .setAccountNonLocked(true)
                .setAccountNonExpired(true)
                .setCredentialsNonExpired(true);
        userMapper.insert(user);
    }

    @Override
    public void update(UserDTO dto) {

    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UserVO detail(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
