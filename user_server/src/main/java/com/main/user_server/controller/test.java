package com.main.user_server.controller;

import com.main.user_server.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public void hello() {
        System.out.println("Hello world!");
    }
}
