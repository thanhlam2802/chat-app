package com.example.chat.chat_backend.DAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.chat.chat_backend.Bean.room;
import com.example.chat.chat_backend.Bean.user;




public interface roomDAO extends MongoRepository<room,ObjectId>{

	@Query("{ 'members': { $in: [?0] } }")
	List<room> findByMembersContainingAndTypeIsFalse(ObjectId userId);

	@Aggregation(pipeline = {
		    "{ '$match': { '$and': [ { 'members': { '$size': 2 } }, { 'members': { '$nin': [?0] } } ] } }",
		    "{ '$unwind': '$members' }",
		    "{ '$match': { 'members': { '$ne': ?0 } } }",
		    "{ '$lookup': { " +
		        " 'from': 'messages', " +
		        " 'let': { 'userB': '$members' }, " +
		        " 'pipeline': [ " +
		            "{ '$match': { '$expr': { '$or': [ " +
		                "{ '$and': [ { '$eq': ['$sender', ?0] }, { '$eq': ['$receiver', '$$userB'] } ] }, " +
		                "{ '$and': [ { '$eq': ['$receiver', ?0] }, { '$eq': ['$sender', '$$userB'] } ] } " +
		            "] } } } " +
		        "], " +
		        " 'as': 'chatHistory' " +
		    "} }",
		    "{ '$match': { 'chatHistory': { '$size': 0 } } }"
		})
		List<room> findUsersNeverChattedWith(ObjectId userId);

}
