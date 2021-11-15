package com.lc.security.oauth.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * 认证服务器
 * <p>
 * 三大类配置：
 *   1.安全配置：访问策略、认证策略、加密方式等。
 *   2.客户端配置：接入客户端的相关信息，如 client_id、client_secret、授权类型、授权范围等。
 *   3.端点配置：端点增强、端点自定义、token存储方式、token生成、token授权、token转换等。
 * </p>
 *
 * @author luchao
 * @date 2021/11/11
 */
@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 安全配置
     *
     * @param security 安全配置
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 让 /oauth/token 支持 client_id + client_secret 做登录认证
        security.allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    /**
     * 客户端配置
     *
     * @param clients client配置
     * @throws Exception Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        String clientSecret = "123456";
        clients.inMemory()
                // admin
                .withClient("admin")
                .secret(clientSecret)
                .scopes("all", "app", "web")
                .authorizedGrantTypes("refresh_token", "authorization_code", "password", "client_credentials", "implicit")
                // app
                .and()
                .withClient("app")
                .secret(clientSecret)
                .scopes("app")
                .authorizedGrantTypes("password", "refresh_token")
                // web
                .and()
                .withClient("web")
                .secret(clientSecret)
                .scopes("web")
                .authorizedGrantTypes("password", "refresh_token");
    }

    /**
     * 端点配置
     *
     * @param endpoints 端点配置
     * @throws Exception Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                // 配置令牌存储
                .tokenStore(new InMemoryTokenStore())
                .userDetailsService(userDetailsService);
    }
}
