package com.msh.springboot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/","/login"})
    public String login(){
        return "adminLogin";
    }
}
