package com.example.chat.chat_backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HellowordController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}