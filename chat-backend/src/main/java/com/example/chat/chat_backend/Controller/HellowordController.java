package com.example.chat.chat_backend.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.userService;
@CrossOrigin(origins = "http://localhost:5174")
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
    
    
    @GetMapping("/friends/{userId}")
    public ResponseEntity<?> findFriendByUserId(@PathVariable String userId) {
        try {
            ObjectId objectId = new ObjectId(userId);
            List<Map<String, Object>> friends = chatService.getUsersWithLatestMessage(objectId);
            return ResponseEntity.ok(friends);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi tìm bạn bè");
        }
    }
  
   
}