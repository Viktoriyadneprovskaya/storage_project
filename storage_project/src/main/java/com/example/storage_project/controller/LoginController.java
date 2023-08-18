package com.example.storage_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
//    public String login() {
//        return "employees/login";
//    }
    public String login() {
        return "employees/login";
    }

}
