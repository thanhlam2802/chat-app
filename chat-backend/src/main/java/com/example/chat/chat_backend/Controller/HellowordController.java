package com.example.chat.chat_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Service.userService;

@RestController
@RequestMapping("/api")
public class HellowordController {
	@Autowired userService utilUser;
    @GetMapping("/hello")
    public String hello() {
    	utilUser.findAll().forEach(u ->{
    		System.out.println(u);
    	});
        return "chafooo màyyyyyyyyy!";
    }
}