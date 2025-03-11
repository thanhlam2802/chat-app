package com.example.chat.chat_backend.DAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.chat.chat_backend.Bean.room;

public interface roomDAO extends MongoRepository<room,ObjectId>{

	@Query("{ 'members': { $in: [?0] }, 'type': false }")
	List<room> findByMembersContainingAndTypeIsFalse(ObjectId userId);





	
}
