package com.example.chat.chat_backend.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.tinNhan;
import com.example.chat.chat_backend.DAO.tinNhanDAO;
import com.example.chat.chat_backend.Service.tinNhanService;

@Service
public class tinNhanServiceImpl implements tinNhanService{
@Autowired tinNhanDAO dao;
	@Override
	public tinNhan createtinNhan(tinNhan r) {
		 
		return dao.save(r);
	}

	@Override
	public void deletetinNhan(String id) {
		 dao.deleteById(id);
		
	}

	@Override
	public tinNhan updatetinNhan(tinNhan r) {
		 
		return dao.save(r);
	}

	@Override
	public tinNhan findById(String id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<tinNhan> findAll() {
		 
		return dao.findAll();
	}

}
