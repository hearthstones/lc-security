package com.lc.security.oauth.pojo.dto;

import com.lc.security.oauth.constants.RegexpConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 短信登录DTO
 *
 * @author luchao
 * @date 2021/11/16
 */
@Data
@ApiModel("短信登录DTO")
public class SmsDTO {

    @ApiModelProperty(value = "手机号", example = "18508806666", required = true)
    @NotBlank(message = "手机号必填")
    @Pattern(regexp = RegexpConst.MOBILE_REG, message = "手机号格式错误")
    private String mobile;

    @ApiModelProperty(value = "验证码", example = "445566", required = true)
    @NotBlank(message = "验证码必填")
    @Pattern(regexp = RegexpConst.MOBILE_CODE_REG, message = "请输入六位数字验证码")
    private String code;

}
