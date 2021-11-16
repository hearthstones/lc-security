package com.lc.security.oauth.pojo.dto;

import com.lc.security.oauth.constants.RegexpConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 账号密码登录DTO
 *
 * @author luchao
 * @date 2021/11/16
 */
@Data
@ApiModel("账号密码登录DTO")
public class AccountDTO {

    @ApiModelProperty(value = "账号（手机号）", example = "18508806666", required = true)
    @NotBlank(message = "账号（手机号）必填")
    @Pattern(regexp = RegexpConst.MOBILE_REG, message = "手机号格式错误")
    private String mobile;

    @ApiModelProperty(value = "密码", example = "123456", required = true)
    @NotBlank(message = "密码必填")
    private String password;
}
