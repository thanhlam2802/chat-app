package com.example.chat.chat_backend.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public interface SessionService {
	
	public <T> T get(String name);
	public void set(String name, Object value) ;
	public void remove(String name);


}
