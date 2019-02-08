package com.spring.social.membership.controller;

import com.spring.social.membership.service.NonSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    NonSocialService nonSocialService;

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
