package com.spring.social.membership.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
@Data
@NoArgsConstructor
public abstract  class User {

    @Id
    @GeneratedValue
    private Long num;

    private String authority; //need another setting!


    //later add created_at, updated_at.
    private String nickname;

}