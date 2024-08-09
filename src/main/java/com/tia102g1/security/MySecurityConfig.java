package com.tia102g1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Bean
    //設定密碼的加密機制為BCrypt方式
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                //css、js等美化模板不需要認證，所以直接讓spring security認證通過才能讀取完整頁面
                .mvcMatchers("/css/**", "/js/**", "/frontendapp/**", "/plungins/**").permitAll()
                .mvcMatchers("/members/register", "/index", "/register", "/login/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login") // 指定自定義的登入頁面
                .permitAll()
                .loginProcessingUrl("/login") // 登入表單提交的 URL
                .defaultSuccessUrl("/index", false) // 登入成功後的響應的 URL
//                .failureUrl("/login?error=true") // 登入失敗後的響應的 URL
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .csrf().disable();
    }

}
