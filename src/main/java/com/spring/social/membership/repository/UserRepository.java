package com.spring.social.membership.repository;

import com.spring.social.membership.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 4. add Userrepository.
 * i need more study about @EntityGraph.
 */
public interface UserRepository extends JpaRepository<User, Long>{

    @EntityGraph(attributePaths = {"userRoles", "userRoles.userRole"})
    @Query("select distinct u from User u where u.email=:email")
    User findByEmail(@Param("email") String email);
}