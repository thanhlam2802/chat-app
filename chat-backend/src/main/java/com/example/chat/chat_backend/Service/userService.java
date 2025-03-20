package com.example.chat.chat_backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DTO.LoginDTO;

public interface userService {
	user createuser(user r);
	void deleteuser(ObjectId id);
	user updateuser(user r);
	user findById(ObjectId id);
	List<user> findAll();
	Boolean checkLogin (LoginDTO lg);
	user findByName(String name);
	int getBanChung(ObjectId idUser1, ObjectId idUser2);
	List<user> findOut(ObjectId id);
}
