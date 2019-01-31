package com.spring.social.membership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class MembershipController {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
