package com.lc.security.oauth.controller;

import com.lc.security.oauth.pojo.dto.AccountDTO;
import com.lc.security.oauth.pojo.dto.SmsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * APP端登录
 *
 * @author luchao
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/oauth/app")
@Api(value = "APP端授权", tags = "认证 - APP端")
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "hello oauth app";
    }

    @PostMapping("/account")
    @ApiOperation("账号密码授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", example = "app", required = true, paramType = "header"),
            @ApiImplicitParam(name = "client_secret", example = "123456", required = true, paramType = "header"),
    })
    public OAuth2AccessToken account(@RequestBody @Valid AccountDTO dto, HttpServletRequest request) {

        return null;
    }

    @PostMapping("/sms")
    @ApiOperation("短信验证码授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", example = "app", required = true, paramType = "header"),
            @ApiImplicitParam(name = "client_secret", example = "123456", required = true, paramType = "header"),
    })
    public OAuth2AccessToken sms(@RequestBody @Valid SmsDTO dto, HttpServletRequest request) {

        return null;
    }

}
