package com.spring.social.membership.service;

import com.spring.social.membership.entity.SocialUser;
import com.spring.social.membership.entity.User;
import com.spring.social.membership.entity.UserRole;
import com.spring.social.membership.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * 7. add UserService.
 * later, add @Transactional.
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Transactional
    public User getOrSave(SocialUser socialUser){
        User saveUser = userRepository.findByEmail(socialUser.getEmail());
        if(saveUser==null){
            User newUser = socialUser.toEntity();
            newUser.addRole(new UserRole("ROLE_USER"));
            saveUser=userRepository.save(newUser);
        }
        return saveUser;
    }
}
