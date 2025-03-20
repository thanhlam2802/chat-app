package com.example.chat.chat_backend.Implement;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.Friends;
import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DAO.FriendsDAO;
import com.example.chat.chat_backend.DAO.roomDAO;
import com.example.chat.chat_backend.DAO.userDAO;
import com.example.chat.chat_backend.DTO.LoginDTO;
import com.example.chat.chat_backend.Service.userService;

@Service
public class userServiceImpl implements userService {
	@Autowired userDAO dao;
	@Autowired roomDAO rdao;
	@Autowired FriendsDAO frDAO;
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
	public List<Map<String, Object>> findOut(ObjectId id) {
		 List<Map<String,Object>> rs = new ArrayList<>();
		List<user> all = dao.findAll();
		List<user>fr = new ArrayList<user>();
		List<Friends> frs = frDAO.findActiveFriends(id);
		frs.forEach(f ->{
			System.out.println("tìm bạn");
			if(f.getGui().equals(id)) {
				Optional<user> us = dao.findById(f.getNhan());
				fr.add(us.orElse(null));
				System.out.println("tìm đc bạn:"+us.orElse(null).getName());
			}else {
				Optional<user> us = dao.findById(f.getGui());
				fr.add(us.orElse(null));
				System.out.println("tìm đc bạn:"+us.orElse(null).getName());
			}
		});
		
		for(user r :all) {
			boolean checkFr= false;
			if (r.getId().equals(id)) {
				checkFr = true;
				
			}else {
				for(user frr: fr) {
					if (r.getId().equals(frr.getId())) {
						checkFr = true;
						break;
					}
				}
			}
			if (!checkFr) {
				System.out.println("không phải là bạn: "+r.getName());
				Map<String,Object> m = new HashMap<>();
				m.put("user", r);
				m.put("relationship", frDAO.findFriendship(id,r.getId()).orElse(null));
				rs.add(m);
		}
		
	}
		return rs;
}
	
	}
