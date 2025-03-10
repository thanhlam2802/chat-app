package com.example.chat.chat_backend.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.room;
import com.example.chat.chat_backend.DAO.roomDAO;
import com.example.chat.chat_backend.Service.roomService;

@Service
public class roomServiceImpl implements roomService {
@Autowired roomDAO dao;
	@Override
	public room createRoom(room r) {
		 
		return dao.save(r);
	}

	@Override
	public void deleteRoom(String id) {
		 dao.deleteById(id);
		
	}

	@Override
	public room updateRoom(room r) {
		 
		return dao.save(r);
	}

	@Override
	public room findById(String id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<room> findAll() {
		 
		return dao.findAll();
	}

}
