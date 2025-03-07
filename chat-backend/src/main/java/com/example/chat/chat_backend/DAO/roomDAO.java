package com.example.chat.chat_backend.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.chat.chat_backend.Bean.room;

public interface roomDAO extends MongoRepository<room,String>{

}
