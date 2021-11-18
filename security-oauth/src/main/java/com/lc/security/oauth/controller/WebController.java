package com.lc.security.oauth.controller;

import com.lc.security.oauth.pojo.dto.WebDTO;
import com.lc.security.oauth.strategy.web.WebUsernamePasswordAuthenticationToken;
import com.lc.security.oauth.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 浏览器端登录
 *
 * @author luchao
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/oauth/web")
@Api(value = "平台端授权", tags = "认证 - 平台端")
public class WebController {

    @Resource
    private TokenUtil tokenUtil;

    @PostMapping("/account")
    @ApiOperation("账号密码授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client_id", example = "web", required = true, paramType = "header"),
            @ApiImplicitParam(name = "client_secret", example = "123456", required = true, paramType = "header"),
    })
    public OAuth2AccessToken web(@RequestBody @Valid WebDTO dto, HttpServletRequest request) {
        WebUsernamePasswordAuthenticationToken token = new WebUsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        return tokenUtil.buildAccessToken(request, token, "custom");
    }
}
