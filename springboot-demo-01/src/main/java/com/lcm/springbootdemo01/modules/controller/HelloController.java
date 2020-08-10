package com.lcm.springbootdemo01.modules.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helloController")
@Slf4j
public class HelloController {

    @Value("${user.uz}")
    private String username;
    @Value("${user.password}")
    private String password;

    @GetMapping("/test")
    public String test(){
        log.info(username+password);
        return new StringBuffer().append(username).append(password).toString();
    }

}
