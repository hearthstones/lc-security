package com.lc.security.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户类
 *
 * @author hearthstones
 * @date 2021/11/8
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;

    private String userid;

    private String username;

    private String password;

    private String clearText;

    private String mobile;

    private Boolean enabled;

    private Boolean accountNonLocked;

    private Boolean accountNonExpired;

    private Boolean credentialsNonExpired;
}