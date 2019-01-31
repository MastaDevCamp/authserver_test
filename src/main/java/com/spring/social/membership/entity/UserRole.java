package com.spring.social.membership.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    public UserRole(String role) {
        this.role = role;
    }
}