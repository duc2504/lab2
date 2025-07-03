package com.example.java6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html hoặc login.jsp
    }

    @GetMapping("/access-denied.html")
    public String denied() {
        return "access-denied"; // access-denied.html
    }
}

