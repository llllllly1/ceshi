package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("hello")
    public User hello(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
