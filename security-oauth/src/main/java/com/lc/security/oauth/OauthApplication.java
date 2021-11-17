package com.lc.security.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OAuthApplication
 *
 * @author luchao
 * @date 2021/11/12
 */
@MapperScan(basePackages = {"com.lc.security.user.mapper"})
@SpringBootApplication
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

}
