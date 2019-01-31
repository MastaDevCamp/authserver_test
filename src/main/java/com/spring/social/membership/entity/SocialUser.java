package com.spring.social.membership.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialUser implements Serializable {

    @JsonProperty("id")
    private String social_id;
    @JsonProperty("provider")
    private String provider;

    @Builder
    public SocialUser(String social_id, String provider) {
        this.social_id = social_id;
        this.provider = provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public User toEntity(){
        return User.builder()
                .provider(provider)
                .social_id(social_id)
                .build();
    }
}