package com.example.chat.chat_backend.Implement;

import java.util.Base64;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DAO.userDAO;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.userService;

@Service
public class userServiceImpl implements userService {
	@Autowired userDAO dao;
	@Override
	public user createuser(user r) {
		return dao.save(r);
	}

	@Override
	public void deleteuser(ObjectId id) {
//		 dao.deleteById(id);
		
	}

	@Override
	public user updateuser(user r) {
		 
		return dao.save(r);
	}

	@Override
	public user findById(ObjectId id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<user> findAll() {
		 
		return dao.findAll();
	}

	@Override
	public Boolean checkLogin(LoginDTO lg) {
		user ud = dao.findByName(lg.getUserName());
		if (ud != null) {
			String endb=new String(Base64.getDecoder().decode(new StringBuilder(ud.getPass().substring(9, ud.getPass().length())).reverse().toString()));
			
			return lg.getPassword().equals(endb) ? true : false;
		}
		return false;
		
	}

	@Override
	public user findByName(String name) {
		return dao.findByName(name);
	}

}
