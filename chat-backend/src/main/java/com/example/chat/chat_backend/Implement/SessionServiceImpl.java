package com.example.chat.chat_backend.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Service.SessionService;

import jakarta.servlet.http.HttpSession;



@Service
public class SessionServiceImpl implements SessionService{
	@Autowired HttpSession ses;
	
	public <T> T get(String name) {
		 return ses != null ? (T) ses.getAttribute(name): null;
	}
	public void set(String name, Object value) {
		ses.setAttribute(name, value);
	}
	public void remove(String name) {
		ses.removeAttribute(name);
	}
}
