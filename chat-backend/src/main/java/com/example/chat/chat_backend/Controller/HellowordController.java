package com.example.chat.chat_backend.Controller;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.SessionService;
import com.example.chat.chat_backend.Service.userService;


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
    	
//    	utilUser.findAll().forEach(u ->{
//    		System.out.println(u.getId());
//    	});
//
//    	ObjectId userId = new ObjectId("67ca664cdba853068a93a5df");
//    	System.out.print((chatService.getUsersWithLatestMessage(userId)));
//    	
    	String pas= "9869228adzITM";
//    	String random = UUID.randomUUID().toString().replace("-", "").substring(0, 9);
//    	String base =new StringBuilder(Base64.getEncoder().encodeToString(pas.getBytes())+random).reverse().toString();
    	
    	String endb=new String(Base64.getDecoder().decode(new StringBuilder(pas.substring(9, pas.length())).reverse().toString()));
//    	String bas2 =Base64.getEncoder().encodeToString(pas.getBytes());
//    	String endb2= new String(Base64.getDecoder().decode(bas2));
//    	System.out.println("mã hóa kiểu khang: "+base);
//    	
//    	System.out.println("mã hóa thường: "+bas2);
    	System.out.println("đọc kiểu khang: "+endb);
//    	System.out.println("đọc kiểu thường: "+endb2);
        return "chafooo màyyyyyyyyy!";
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<Boolean> dangnhap(@RequestBody LoginDTO u) {
    	
    	if (utilUser.checkLogin(u)) {
    		System.out.println("có đẩy lên ses");
    		ses.set("userLog", utilUser.findByName(u.getUserName()));
    		System.out.println("đọc ngay sau khi đẩy: "+ses.get("userLog"));
    	}
        return ResponseEntity.ok(utilUser.checkLogin(u)); 
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