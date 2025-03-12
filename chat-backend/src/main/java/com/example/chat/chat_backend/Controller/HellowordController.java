package com.example.chat.chat_backend.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.userService;
@CrossOrigin(origins = "http://localhost:5173")
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
    
    @PostMapping("/login")
    public ResponseEntity<Boolean> postMethodName(@RequestBody LoginDTO u) {
    	System.out.println("áaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	System.out.println(u.toString());
        
        return ResponseEntity.ok(true);
    }
    
   
}