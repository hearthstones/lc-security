package com.lc.security.user.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * UserVO
 *
 * @author luchao
 * @date 2021/11/8
 */
@Data
@ApiModel("用户VO")
public class UserVO {
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
