package com.spring.social.membership.service;

import com.spring.social.membership.entity.SocialUser;
import lombok.AllArgsConstructor;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
public class SocialService {
    private final UserService userService;

    public UsernamePasswordAuthenticationToken doAuthentication(SocialUser socialUser){
        userService.getOrSave(socialUser);
        return setAuthenticationToken(socialUser);
    }

    private UsernamePasswordAuthenticationToken setAuthenticationToken(Object user){
        return new UsernamePasswordAuthenticationToken(user,null,getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
