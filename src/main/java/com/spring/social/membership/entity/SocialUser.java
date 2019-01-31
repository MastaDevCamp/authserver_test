package com.spring.social.membership.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 6. add Social User.
 * this is not Entity class. this is only data transfer data.
 * add Social User. this only connected for google.
 */
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialUser implements Serializable {

    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("picture")
    private String picture;

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .imageUrl(picture)
                .build();
    }
}