package com.spring.social.config.Handlers;

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

@Component
public class GoogleSuccessHandler implements AuthenticationSuccessHandler {
    private HttpSession httpSession;
    private ObjectMapper objectMapper;
    private UserService userService;

    public GoogleSuccessHandler(HttpSession httpSession, ObjectMapper objectMapper, UserService userService) {
        this.httpSession = httpSession;
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Object obj = ((OAuth2Authentication) authentication).getOAuth2Request();
        SocialUser socialUser = objectMapper.convertValue(oAuth2Authentication.getUserAuthentication().getDetails(),SocialUser.class);
        socialUser.setProvider("google");
        userService.getOrSave(socialUser);
        response.sendRedirect("/auth/me");
    }

}
