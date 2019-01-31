package com.spring.social.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.social.membership.entity.SocialUser;
import com.spring.social.membership.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 8. update LoginSuccess Handler.
 * this class is updated for save user data to mysql.
 * to save user service, use UserService. (i'm confused using userService vs using userRepositor & userRoleRepository)
 */

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private HttpSession httpSession;
    private ObjectMapper objectMapper;
    private UserService userService;

    public LoginSuccessHandler(HttpSession httpSession, ObjectMapper objectMapper, UserService userService) {
        this.httpSession = httpSession;
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("hello~");
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        SocialUser socialUser = objectMapper.convertValue(oAuth2Authentication.getUserAuthentication().getDetails(),SocialUser.class);
        userService.getOrSave(socialUser);
        response.sendRedirect("/auth/me");
    }

}
