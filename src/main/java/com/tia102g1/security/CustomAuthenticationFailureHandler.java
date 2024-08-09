package com.tia102g1.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String error;
        // 根據不同的異常類型設置具體的錯誤消息
        if (exception.getCause() instanceof UsernameNotFoundException) {
            error = "true";
        } else if (exception instanceof BadCredentialsException) {
            error = "false";

            // 執行重定向
            response.sendRedirect("/login?error=" + error);
        }
    }
}
