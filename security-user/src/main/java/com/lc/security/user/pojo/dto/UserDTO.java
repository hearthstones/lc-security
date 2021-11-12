package com.lc.security.user.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 新增/编辑用户DTO
 *
 * @author luchao
 * @date 2021/11/8
 */
@Data
@ApiModel("新增/编辑用户DTO")
public class UserDTO {

    private Integer id;

    private String userid;

    private String username;

    private String password;

    private String mobile;
}
