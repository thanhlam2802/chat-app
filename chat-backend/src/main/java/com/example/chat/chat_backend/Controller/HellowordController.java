package com.example.chat.chat_backend.Controller;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.chat.chat_backend.Bean.Friends;
import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.ChatService;
import com.example.chat.chat_backend.Service.FriendsService;
import com.example.chat.chat_backend.Service.SessionService;
import com.example.chat.chat_backend.Service.roomService;
import com.example.chat.chat_backend.Service.userService;


@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

@RestController
@RequestMapping("/api")
public class HellowordController {
	@Autowired userService utilUser;
	@Autowired roomService utilroom;
	@Autowired
    private ChatService chatService;
	@Autowired FriendsService frSer;
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
//<<<<<<< HEAD
//
//    	String pas= "53b62ee3f=MjMx4WY";


//    	String pas= "2b97347a72UDN";
//    	String endb=new String(Base64.getDecoder().decode(new StringBuilder(pas.substring(9, pas.length())).reverse().toString()));
//    	System.out.println("đọc kiểu khang: "+endb);
    	

//    	String random = UUID.randomUUID().toString().replace("-", "").substring(0, 9);
//    	String base =new StringBuilder(Base64.getEncoder().encodeToString(pas.getBytes())+random).reverse().toString();
//    	String bas2 =Base64.getEncoder().encodeToString(pas.getBytes());
//    	String endb2= new String(Base64.getDecoder().decode(bas2));
//    	System.out.println("mã hóa kiểu khang: "+base);
//    	System.out.println("mã hóa thường: "+bas2);
//    	System.out.println("đọc kiểu thường: "+endb2);
    	utilroom.findAll().forEach(r ->{
    		System.out.println("id: "+r.getId());
    		System.out.println("name: "+r.getName());
    	});
    	
    	
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
        	System.out.println("lkieems ban be ");
            ObjectId objectId = new ObjectId(userId);
            List<Map<String, Object>> friends = chatService.getUsersWithLatestMessage(objectId);
        	System.out.println(friends);
             friends.forEach(m ->{
            	System.out.println("-------------------------");
            	System.out.println(m.get("user"));
            	System.out.println(m.get("latestMessage"));
            	System.out.println("-------------------------");
            });
            return ResponseEntity.ok(friends);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi tìm bạn bè");
        }
    }

    @GetMapping("/listfriends/{userId}")
    public ResponseEntity<?> getListFr(@PathVariable String userId) {
        try {
        	System.out.println("lkieems ban beeeeeeeeeeeeee ");
            ObjectId objectId = new ObjectId(userId);
            List<Map<String, Object>> friends = chatService.ListFriend(objectId);
             friends.forEach(m ->{
            	System.out.println("-------------------------");
            	System.out.println(m.get("user"));
            	System.out.println(m.get("latestMessage"));
            	System.out.println("-------------------------");
            });
            return ResponseEntity.ok(friends);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi tìm bạn bè: ");
        }
    }
    @GetMapping("/listNotFriends/{userId}")
    public ResponseEntity<?> getListNotFr(@PathVariable String userId) {
    	System.out.println("lấy ko bạn bèeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        try {
            ObjectId objectId = new ObjectId(userId);
            System.out.println(userId);
            List<Map<String,Object>> notfriends = utilUser.findOut(objectId);
            
            return ResponseEntity.ok(notfriends);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi khi tìm bạn bè: ");
        }
    }
    @GetMapping("/link-preview")
    public Map<String, Object> getLinkPreview( @RequestParam String url ) {
        String apiKey = "8391aa05cff581489bf6635ec23d6e24"; 
        String apiUrl = "https://api.linkpreview.net/?key=" + apiKey + "&q=" + url;
        
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, Map.class);

    }

   @GetMapping("/addFriend/{id}")
   public ResponseEntity<?> addFriend(@PathVariable ("id")String id) {
	   user lg = ses.get("userLog");
	   ObjectId objectId = new ObjectId(id);
	   Friends fr = new Friends();
	   fr.setGui(lg.getId());
	   fr.setNhan(objectId);
	   fr.setStatus(false);
	   frSer.create(fr);
       return ResponseEntity.ok(true);
   }
   @GetMapping("/accecpt/{id}")
   public ResponseEntity<?> accecpt(@PathVariable ("id")String id) {
	  
	   ObjectId objectId = new ObjectId(id);
	   Friends df = frSer.findById(objectId);
	   df.setStatus(true);
	   frSer.update(df);
       return ResponseEntity.ok(true);
   }
}	