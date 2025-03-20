package com.example.chat.chat_backend.DAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.chat.chat_backend.Bean.user;

public interface userDAO extends MongoRepository<user, ObjectId> {

	user findByNameAndPass(String name, String pass);

	user findByName(String name);

	@Aggregation(pipeline = {
	        "{'$match': {'members': {'$all': [?0, ?1]}}}",
	        "{'$unwind': '$members'}",
	        "{'$match': {'members': {'$nin': [?0, ?1]}}}",
	        "{'$group': {'_id': '$members', 'count': {'$sum': 1}}}",
	        "{'$count': 'commonFriends'}"
	    })
	    Integer countCommonFriends(ObjectId userA, ObjectId userB);
	



}
