package com.example.chat.chat_backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.room;

public interface roomService {
	room createRoom(room r);
	void deleteRoom(ObjectId id);
	room updateRoom(room r);
	room findById(ObjectId id);
	List<room> findAll();
//	List <room> findbyMember(String id);
}
