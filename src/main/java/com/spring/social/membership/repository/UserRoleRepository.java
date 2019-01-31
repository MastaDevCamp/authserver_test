package com.spring.social.membership.repository;

import com.spring.social.membership.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 5. add UserRoleRepository.
 *
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

    @Query("select ur from UserRole ur where ur.role='ROLE_USER'")
    UserRole findDefaultRole();
}
