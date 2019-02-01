package com.spring.social.membership.repository;

import com.spring.social.membership.entity.NonSocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NonSocialUserRepository  extends JpaRepository<NonSocialUser, Long> {
    NonSocialUser findByUsername(String username);
}
