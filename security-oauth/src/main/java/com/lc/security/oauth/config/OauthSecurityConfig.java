package com.lc.security.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * OauthSecurityConfig
 *
 * @author luchao
 * @date 2021/11/12
 */
@Configuration
@EnableWebSecurity
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean(name = "userDetailsService")
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return createUserDetailsService();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return createUserDetailsService();
    }

    private UserDetailsService createUserDetailsService() {
        String password = passwordEncoder().encode("123456");

        List<UserDetails> users = new ArrayList<>();

        UserDetails admin = User.withUsername("admin").password(password).authorities("ADMIN", "USER").build();
        UserDetails user1 = User.withUsername("user1").password(password).authorities("ADMIN", "USER").build();
        UserDetails user2 = User.withUsername("user2").password(password).authorities("USER").build();

        users.add(admin);
        users.add(user1);
        users.add(user2);

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .anyRequest()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}
