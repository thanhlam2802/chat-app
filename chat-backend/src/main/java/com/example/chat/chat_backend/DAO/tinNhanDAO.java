package com.example.chat.chat_backend.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.chat.chat_backend.Bean.tinNhan;

public interface tinNhanDAO  extends MongoRepository<tinNhan, String>{
	
	
}
