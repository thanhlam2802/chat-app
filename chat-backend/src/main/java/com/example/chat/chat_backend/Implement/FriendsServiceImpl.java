package com.example.chat.chat_backend.Implement;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import com.example.chat.chat_backend.Bean.Friends;
import com.example.chat.chat_backend.DAO.FriendsDAO;
import com.example.chat.chat_backend.Service.FriendsService;

@Component
public class FriendsServiceImpl implements FriendsService{
	@Autowired FriendsDAO dao;
	@Override
	public void create(Friends fr) {
		dao.save(fr);
		
	}
	@Override
	public void update(Friends fr) {
		dao.save(fr);
		
	}
	@Override
	public Friends findById(ObjectId id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
