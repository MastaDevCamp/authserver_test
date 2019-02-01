package com.spring.social.membership.service;

import com.spring.social.membership.entity.NonSocialUser;
import com.spring.social.membership.repository.NonSocialUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class NonSocialService implements UserDetailsService {
    private  final NonSocialUserRepository nonSocialUserRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public NonSocialService(NonSocialUserRepository nonSocialUserRepository) {
        this.nonSocialUserRepository = nonSocialUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NonSocialUser nonSocialUser = nonSocialUserRepository.findByUsername(username);
        nonSocialUser.setAuthorities(nonSocialUser.getAuthorities());
        return nonSocialUser;
    }

    public void createUser(NonSocialUser nonSocialUser){
        String pw = nonSocialUser.getPassword();
        String encodedPw = new BCryptPasswordEncoder().encode(pw);
        nonSocialUser.setPassword(encodedPw);
        nonSocialUser.setAuthority("ROLE_USER");
        nonSocialUserRepository.save(nonSocialUser);
    }

    public PasswordEncoder passwordEncoder(){
        return this.passwordEncoder;
    }
}
