package com.example.chat.chat_backend.Service;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.Friends;

public interface FriendsService {
	void create(Friends fr);
	void update(Friends fr);
	Friends findById(ObjectId id);
}
