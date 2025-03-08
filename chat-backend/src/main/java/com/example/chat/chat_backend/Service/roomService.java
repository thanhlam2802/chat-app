package com.example.chat.chat_backend.Service;

import java.util.List;

import com.example.chat.chat_backend.Bean.room;

public interface roomService {
	room createRoom(room r);
	void deleteRoom(String id);
	room updateRoom(room r);
	room findById(String id);
	List<room> findAll();
}
