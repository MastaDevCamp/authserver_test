package com.spring.social.membership.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String provider;
    private String social_id;


    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval=true)
    private List<UserRoleMap> userRoles = new ArrayList<>();

    @Builder
    public User(String social_id, String provider, List<UserRoleMap> userRoles) {
        this.provider=provider;
        this.social_id=social_id;
        this.userRoles = userRoles;
    }

    public void addRole(UserRole userRole){
        if(userRoles == null){
            userRoles = new ArrayList<>();
        }
        userRoles.add(new UserRoleMap(this, userRole));
    }
}