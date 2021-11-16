package com.lc.security.oauth.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 平台端账号密码登录DTO
 *
 * @author luchao
 * @date 2021/11/16
 */
@Data
@ApiModel("平台端账号密码登录DTO")
public class WebDTO {

    @ApiModelProperty(value = "账号（用户名/手机号）", required = true)
    @NotBlank(message = "账号必填")
    private String username;

    @ApiModelProperty(value = "密码", example = "123456", required = true)
    @NotBlank(message = "密码必填")
    private String password;
}
