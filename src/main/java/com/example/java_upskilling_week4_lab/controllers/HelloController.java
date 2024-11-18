package com.example.java_upskilling_week4_lab.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${my-application.welcome}")
    private String welcomeMessage;

    @GetMapping("/hello")
    public String hello() {
        return welcomeMessage;
    }
}
