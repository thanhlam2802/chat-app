package com.example.chat.chat_backend.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.userService;

@RestController
@RequestMapping("/api")
public class HellowordController {
	@Autowired userService utilUser;
	@Autowired
    private ChatService chatService;
    @GetMapping("/hello")
    public String hello() {
    	utilUser.findAll().forEach(u ->{
    		System.out.println(u.getId());
    	});

    	ObjectId userId = new ObjectId("67ca664cdba853068a93a5df");
    	System.out.print((chatService.getUsersWithLatestMessage(userId)));
    	
        return "chafooo màyyyyyyyyy!";
    }
    
  
   
}