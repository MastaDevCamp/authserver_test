package com.spring.social.membership.repository;

import com.spring.social.membership.entity.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialUserRepository  extends JpaRepository<SocialUser, Long> {
    Optional<SocialUser> findBySocialId(String id);
}
