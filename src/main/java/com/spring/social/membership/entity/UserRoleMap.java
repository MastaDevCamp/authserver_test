package com.spring.social.membership.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 3. add UserRole Map.
 * this is my jpa model for mysql.
 * this class means mapping user & user_Roles.
 */
@NoArgsConstructor
@Getter
@Entity
public class UserRoleMap {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_MAP"))
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_role_id", foreignKey = @ForeignKey(name = "FK_USER_ROLE_MAP"))
    private UserRole userRole;

    public UserRoleMap(User user, UserRole userRole) {
        this.user = user;
        this.userRole = userRole;
    }
}