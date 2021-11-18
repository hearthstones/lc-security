package com.lc.security.oauth.controller;

import com.lc.security.oauth.pojo.dto.AccountDTO;
import com.lc.security.oauth.pojo.dto.SmsDTO;
import com.lc.security.oauth.strategy.sms.SmsAuthenticationToken;
import com.lc.security.oauth.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * APP端登录
 *
 * @author luchao
 * @date 2021/11/15
 */
@Slf4j
@RestController
@RequestMapping("/oauth/app")
@Api(value = "APP端授权", tags = "认证 - APP端")
public class AppController {

    @Resource
    private TokenUtil tokenUtil;

    @GetMapping("/hello")
    public String hello() {
        return "hello oauth app";
    }

    @GetMapping("/current")
    @ApiIgnore
    public Authentication principal(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("登录用户：{}", authentication);
        return authentication;
    }

    @PostMapping("/account")
    @ApiOperation("账号密码授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", example = "app", required = true, paramType = "header"),
            @ApiImplicitParam(name = "client_secret", example = "123456", required = true, paramType = "header"),
    })
    public OAuth2AccessToken account(@RequestBody @Valid AccountDTO dto, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getMobile(), dto.getPassword());
        return tokenUtil.buildAccessToken(request, token, "password");
    }

    @PostMapping("/sms")
    @ApiOperation("短信验证码授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", example = "app", required = true, paramType = "header"),
            @ApiImplicitParam(name = "client_secret", example = "123456", required = true, paramType = "header"),
    })
    public OAuth2AccessToken sms(@RequestBody @Valid SmsDTO dto, HttpServletRequest request) {
        SmsAuthenticationToken token = new SmsAuthenticationToken(dto.getMobile(), dto.getCode());
        return tokenUtil.buildAccessToken(request, token, "custom");
    }

}
