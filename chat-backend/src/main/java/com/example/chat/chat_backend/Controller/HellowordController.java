package com.example.chat.chat_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Service.roomService;
import com.example.chat.chat_backend.Service.userService;

@RestController

public class HellowordController {
	@Autowired userService utilUser;
	@Autowired roomService room;
	@RequestMapping("/api")
    public String hello() {
    	utilUser.findAll().forEach(u ->{
    		System.out.println(u);
    	});
//		room.findAll().forEach(r ->{
//			System.out.println(r.getId() + "id room");
//			r.getMembers().forEach( m ->{
//				System.out.println(m);
//			});
//		});
		System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
		System.out.println(room.findbyMember("67ca664cdba853068a93a5df").size());
		room.findbyMember("67ca664cdba853068a93a5df").forEach(r ->{
			System.out.println(r.getId()+"id room");
			r.getMembers().forEach(m ->{
				System.out.println(m);
			});
		});
        return "chafooo màyyyyyyyyy!";
    }
}