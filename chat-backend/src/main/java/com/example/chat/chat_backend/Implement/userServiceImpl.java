package com.example.chat.chat_backend.Implement;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DAO.roomDAO;
import com.example.chat.chat_backend.DAO.userDAO;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.userService;

@Service
public class userServiceImpl implements userService {
	@Autowired userDAO dao;
	@Autowired roomDAO rdao;
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

	@Override
	public int getBanChung(ObjectId idUser1, ObjectId idUser2) {
		 Integer count = dao.countCommonFriends(idUser1,idUser2);
		return count != null ? count : 0;
	}

	@Override
	public List<user> findOut(ObjectId id) {
		List<user> ls = new ArrayList<user>();
		System.out.println(rdao.findUsersNeverChattedWith(id).size());
		rdao.findUsersNeverChattedWith(id).forEach(r ->{
//		ls.add(r.getMembers().get(0));
			Optional<user> u = dao.findById( r.getMembers().get(0));
			ls.add(u.orElse(null));
		});
		return ls;
	}

}
