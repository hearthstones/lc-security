package com.lc.security.demo.service.impl;

import com.lc.security.demo.mapper.UserMapper;
import com.lc.security.demo.model.User;
import com.lc.security.demo.pojo.dto.UserDTO;
import com.lc.security.demo.pojo.vo.UserVO;
import com.lc.security.demo.service.UserService;

import org.springframework.beans.BeanUtils;
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

    @Override
    public void add(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()))
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

    }

    @Override
    public UserVO detail(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
