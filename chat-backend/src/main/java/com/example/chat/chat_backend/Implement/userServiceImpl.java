package com.example.chat.chat_backend.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DAO.userDAO;
import com.example.chat.chat_backend.Service.userService;

@Service
public class userServiceImpl implements userService {
	@Autowired userDAO dao;
	@Override
	public user createuser(user r) {
		return dao.save(r);
	}

	@Override
	public void deleteuser(String id) {
		 dao.deleteById(id);
		
	}

	@Override
	public user updateuser(user r) {
		 
		return dao.save(r);
	}

	@Override
	public user findById(String id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<user> findAll() {
		 
		return dao.findAll();
	}

}
