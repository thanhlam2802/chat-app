package com.example.chat.chat_backend.Implement;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.tinNhan;
import com.example.chat.chat_backend.DAO.tinNhanDAO;
import com.example.chat.chat_backend.DTO.TinNhanDTO;
import com.example.chat.chat_backend.Service.tinNhanService;

@Service
public class tinNhanServiceImpl implements tinNhanService{
	
	@Autowired tinNhanDAO dao;
	
	private final  MongoTemplate mongoTemplate;

    @Autowired
    public  tinNhanServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<TinNhanDTO> getMessagesByRoom(ObjectId roomId) {
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("idRoom").is(roomId)), 
            Aggregation.lookup("user", "idNguoiGui", "_id", "nguoiGuiInfo"), 
            Aggregation.unwind("nguoiGuiInfo", true), 
            Aggregation.project("idRoom", "thoiGian", "noiDung", "idNguoiGui", "file")
                .and("nguoiGuiInfo.name").as("tenNguoiGui")
                .and("nguoiGuiInfo.avt").as("avtNguoiGui"),
            Aggregation.sort(Sort.by(Sort.Direction.ASC, "thoiGian")) 
        );

        List<TinNhanDTO> messages = mongoTemplate.aggregate(aggregation, "tinNhan", TinNhanDTO.class)
                                                 .getMappedResults();
        return messages;
    }



	@Override
	public tinNhan createtinNhan(tinNhan r) {
		 
		return dao.save(r);
	}

	@Override
	public void deletetinNhan(ObjectId id) {
		 dao.deleteById(id);
		
	}

	@Override
	public tinNhan updatetinNhan(tinNhan r) {
		 
		return dao.save(r);
	}

	@Override
	public tinNhan findById(ObjectId id) {
		 
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<tinNhan> findAll() {
		 
		return dao.findAll();
	}

	@Override
	public tinNhan create(tinNhan message) {
		// TODO Auto-generated method stub
		if (message.getThoiGian() == null) {
	        message.setThoiGian(new Date());
	    }
		return dao.save(message);
	}



	
	

}
