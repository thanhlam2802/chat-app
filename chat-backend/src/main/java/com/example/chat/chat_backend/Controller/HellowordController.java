package com.example.chat.chat_backend.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.SessionService;
import com.example.chat.chat_backend.Service.userService;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class HellowordController {
	@Autowired userService utilUser;
	@Autowired
    private ChatService chatService;
	@Autowired
	SessionService ses;
	
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
    public ResponseEntity<user> dangnhap(@RequestBody LoginDTO u) {
    	
    	if (utilUser.checkLogin(u)) {
    		ses.set("userLog", utilUser.findByName(u.getUserName()));
    	}
        return ResponseEntity.ok(utilUser.findByName(u.getUserName()));
    }
    
    @GetMapping("/info-user")
    public ResponseEntity<user> getLog() {
    	user lg = ses.get("userLog");
    	if (lg != null) {
    		System.out.println(lg.toString()+"aaaaaaaaaaaaaaa");
    	}else {
    		System.out.println("nul");
    	}
        return ResponseEntity.ok(lg);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<String>  logout() {
    	ses.remove("userLog");
        return ResponseEntity.ok("oke") ;
    }
    
   
}	