package com.example.chat.chat_backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.chat.chat_backend.Bean.tinNhan;

public interface tinNhanService {
	tinNhan createtinNhan(tinNhan r);
	void deletetinNhan(ObjectId id);
	tinNhan updatetinNhan(tinNhan r);
	tinNhan findById(ObjectId id);
	List<tinNhan> findAll();
}
