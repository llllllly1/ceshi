package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("hello")
    public String hello(String name){
        System.out.println(name);
        return "product02:"+name;
    }
}
