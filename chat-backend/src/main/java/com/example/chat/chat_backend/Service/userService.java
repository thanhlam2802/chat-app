package com.example.chat.chat_backend.Service;

import java.util.List;

import com.example.chat.chat_backend.Bean.user;

public interface userService {
	user createuser(user r);
	void deleteuser(String id);
	user updateuser(user r);
	user findById(String id);
	List<user> findAll();
}
