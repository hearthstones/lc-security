package com.lc.security.oauth.utils;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * TokenUtil
 *
 * @author luchao
 * @date 2021/11/16
 */
@Component
public class TokenUtil {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    /**
     * 构造 OAuth2AccessToken
     *
     * @param request request
     * @param token token
     * @param grantType 认证类型
     * @return OAuth2AccessToken
     */
    public OAuth2AccessToken buildAccessToken(HttpServletRequest request,
                                              AbstractAuthenticationToken token,
                                              String grantType) {
        // ClientDetails
        String clientId = request.getHeader("client_id");
        String clientSecret = request.getHeader("client_secret");
        // todo: 获取ClientDetails
        ClientDetails clientDetails = new BaseClientDetails();
        // TokenRequest
        TokenRequest tokenRequest = new TokenRequest(null, clientId, clientDetails.getScope(), grantType);
        // ClientDetails + TokenRequest => OAuth2Request
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        // Authentication
        Authentication authentication = authenticationManager.authenticate(token);
        // OAuth2Request + Authentication => OAuth2Authentication
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        // OAuth2Authentication => OAuth2AccessToken
        return authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
    }

}
