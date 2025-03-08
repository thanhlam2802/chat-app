package com.example.chat.chat_backend.Service;

import java.util.List;

import com.example.chat.chat_backend.Bean.tinNhan;

public interface tinNhanService {
	tinNhan createtinNhan(tinNhan r);
	void deletetinNhan(String id);
	tinNhan updatetinNhan(tinNhan r);
	tinNhan findById(String id);
	List<tinNhan> findAll();
}
