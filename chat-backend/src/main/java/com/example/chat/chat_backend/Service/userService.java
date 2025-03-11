package com.example.chat.chat_backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.user;

public interface userService {
	user createuser(user r);
	void deleteuser(ObjectId id);
	user updateuser(user r);
	user findById(ObjectId id);
	List<user> findAll();
}
