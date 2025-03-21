package com.example.chat.chat_backend.DAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.chat.chat_backend.Bean.tinNhan;

public interface tinNhanDAO  extends MongoRepository<tinNhan, ObjectId>{
	

    List<tinNhan> findByIdRoom(ObjectId idRoom, Pageable pageable);
    
    @Query(value = "{ 'idRoom': ?0 }", sort = "{ 'thoiGian': -1 }")
    List<tinNhan> findByIdRoomOrderByThoiGianDesc(ObjectId idRoom);
}
