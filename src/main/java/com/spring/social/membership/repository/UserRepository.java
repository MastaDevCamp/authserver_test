package com.spring.social.membership.repository;

import com.spring.social.membership.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

}