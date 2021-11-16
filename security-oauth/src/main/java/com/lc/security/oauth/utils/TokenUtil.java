package com.lc.security.oauth.utils;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import javax.servlet.http.HttpServletRequest;

/**
 * TokenUtil
 *
 * @author luchao
 * @date 2021/11/16
 */
public class TokenUtil {

    /**
     * 构造 OAuth2AccessToken
     *
     * @param request request
     * @param token token
     * @param grantType 认证类型
     * @return OAuth2AccessToken
     */
    public static OAuth2AccessToken buildAccessToken(HttpServletRequest request,
                                                     AbstractAuthenticationToken token,
                                                     String grantType) {

        return null;
    }

}
