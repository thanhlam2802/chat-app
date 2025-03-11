package com.example.chat.chat_backend.Implement;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
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
	public void deleteRoom(ObjectId id) {
		 dao.deleteById(id);
		
	}

	@Override
	public room updateRoom(room r) {
		 
		return dao.save(r);
	}

	@Override
	public room findById(ObjectId id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<room> findAll() {
		 
		return dao.findAll();
	}

	@Override
	public List<room> findbyMember(String id) {
		List<room> returnn = new ArrayList<>() ;
		for(int i = 0 ; i <this.findAll().size();i ++) {
			if (this.findAll().get(i).getMembers().get(0).equalsIgnoreCase(id) || this.findAll().get(i).getMembers().get(1).equalsIgnoreCase(id)) {
				returnn.add(this.findAll().get(i));
			}
		}
		return returnn;
	}

}
