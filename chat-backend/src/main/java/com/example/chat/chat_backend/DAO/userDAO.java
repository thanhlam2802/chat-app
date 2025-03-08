package com.example.chat.chat_backend.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.chat.chat_backend.Bean.user;

public interface userDAO  extends MongoRepository<user,String>{

}
