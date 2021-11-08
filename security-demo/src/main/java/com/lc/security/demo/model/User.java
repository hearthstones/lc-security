package com.lc.security.demo.model;

import lombok.Data;

/**
 * 用户类
 *
 * @author hearthstones
 * @date 2021/11/8
 */
@Data
public class User {
    private Integer id;

    private String userid;

    private String username;

    private String password;

    private String mobile;

    private Boolean enabled;

    private Boolean accountNonLocked;

    private Boolean accountNonExpired;

    private Boolean credentialsNonExpired;
}