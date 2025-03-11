package com.example.chat.chat_backend.Service;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

public interface ChatService {
	List<Map<String, Object>> getUsersWithLatestMessage(ObjectId userId);
}
