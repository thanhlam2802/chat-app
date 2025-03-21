package com.example.chat.chat_backend.DAO;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.chat.chat_backend.Bean.Friends;

public interface FriendsDAO extends MongoRepository<Friends, ObjectId> {
	@Query("{ $and: [ { $or: [ { 'gui': ?0 }, { 'nhan': ?0 } ] }, { 'status': true } ] }")
    List<Friends> findActiveFriends(ObjectId userId);
	 @Query("{ $or: [ { $and: [ { 'gui': ?0 }, { 'nhan': ?1 } ] }, { $and: [ { 'gui': ?1 }, { 'nhan': ?0 } ] } ] }")
	    Optional<Friends> findFriendship(ObjectId userId1, ObjectId userId2);
}
