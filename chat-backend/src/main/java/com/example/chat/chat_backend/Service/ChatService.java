package com.example.chat.chat_backend.Service;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.tinNhan;

public interface ChatService {
	List<Map<String, Object>> getUsersWithLatestMessage(ObjectId userId);
	List<Map<String,Object>> ListFriend(ObjectId userId);
	
 }
