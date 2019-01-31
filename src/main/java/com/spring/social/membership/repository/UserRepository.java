package com.spring.social.membership.repository;

import com.spring.social.membership.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{

    @EntityGraph(attributePaths = {"userRoles", "userRoles.userRole"})
    @Query("select distinct u from User u where u.social_id=:social_id")
    User findBySocial_id(@Param("social_id") String social_id);

}