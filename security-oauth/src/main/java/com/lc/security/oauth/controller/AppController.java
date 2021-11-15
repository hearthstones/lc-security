package com.lc.security.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP端登录
 *
 * @author luchao
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/oauth/app")
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "hello oauth app";
    }

}
