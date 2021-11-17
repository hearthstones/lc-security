package com.lc.security.oauth.controller;

import com.lc.security.oauth.utils.SmsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 短信服务 Controller
 *
 * @author luchao
 * @date 2021/11/17
 */
@RestController
@RequestMapping("/sms")
@Api(value = "短信服务", tags = "短信服务")
public class SmsController {

    @Resource
    private SmsUtil smsUtil;

    @GetMapping("/send")
    @ApiOperation("发送短信验证码")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "query")
    public String sendCode(@RequestParam("mobile") String mobile) {
        return smsUtil.sendCode(mobile);
    }

}
