package com.example.chat.chat_backend.Implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.chat.chat_backend.Bean.Friends;
import com.example.chat.chat_backend.Bean.room;
import com.example.chat.chat_backend.Bean.tinNhan;
import com.example.chat.chat_backend.Bean.user;
import com.example.chat.chat_backend.DAO.FriendsDAO;
import com.example.chat.chat_backend.DAO.roomDAO;
import com.example.chat.chat_backend.DAO.tinNhanDAO;
import com.example.chat.chat_backend.DAO.userDAO;
import com.example.chat.chat_backend.Service.ChatService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ChatServicrImpl implements ChatService{
	 @Autowired
	    private roomDAO roomRepository;
	 	@Autowired FriendsDAO frDAO;
	    @Autowired
	    private tinNhanDAO tinNhanRepository;
	    @Autowired userServiceImpl usImpl;
	    @Autowired
	    private userDAO userRepository;
	    @Override
	    public List<Map<String, Object>> getUsersWithLatestMessage(ObjectId userId) {
	        log.info("🔎 Bắt đầu lấy danh sách user nhắn tin với: {}", userId);
	        
	        List<room> rooms = roomRepository.findByMembersContainingAndTypeIsFalse(userId);
	 
	        log.info("📌 Số phòng tìm thấy: {}", rooms.size());
	        System.out.println("📌 Danh sách phòng: " + rooms);

	        List<Map<String, Object>> result = new ArrayList<>();

	        for (room r : rooms) {
	            log.info("🔍 Kiểm tra phòng: {}", r.getId());

	            if (r.getMembers().size() <= 1) {
	                log.warn("⚠ Bỏ qua phòng chỉ có 1 người");
	                continue;
	            }else if (r.getMembers().size() <=2) {
	            	ObjectId otherUserId = r.getMembers().stream()
     	                .filter(id -> !id.equals(userId))
     	                .findFirst()
     	                .orElse(null);

     	            if (otherUserId == null) {
     	                log.warn("⚠ Không tìm thấy user còn lại trong phòng!");
     	                continue;
     	            }

     	            log.info("👤 Người còn lại trong phòng: {}", otherUserId);

     	            List<tinNhan> latestMessages = tinNhanRepository.findByIdRoom(
     	                r.getId(),
     	                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "thoiGian"))
     	            );

     	            tinNhan latestMessage = latestMessages.isEmpty() ? null : latestMessages.get(0);

     	            user OtherUser = userRepository.findById(otherUserId).orElse(null);

     	            if (OtherUser != null) {
     	                log.info("✅ User tìm thấy: {}", OtherUser.getName());

     	                Map<String, Object> data = new HashMap<>();
     	                data.put("user", OtherUser);
     	                data.put("latestMessage", latestMessage);

     	                result.add(data);
     	            } else {
     	                log.warn("⚠ Không tìm thấy thông tin user từ database!");
     	            }
	            }else  if (r.getMembers().size() >2){
     	            List<tinNhan> latestMessages = tinNhanRepository.findByIdRoom(
     	                r.getId(),
     	                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "thoiGian"))
     	            );
     	            tinNhan latestMessage = latestMessages.isEmpty() ? null : latestMessages.get(0);

 	                Map<String, Object> data = new HashMap<>();
 	                data.put("user", r);
 	                data.put("latestMessage", latestMessage);

 	                result.add(data);
	            }
	        }
	        log.info("📦 Trả về {} user có tin nhắn", result.size());
	        return result;
	    }
		@Override
		public List<Map<String, Object>> ListFriend(ObjectId userId) {
			
			List<Friends> frs = frDAO.findActiveFriends(userId);
			frs.forEach(f->{
				System.out.println(f.toString());
			});
			List<Map<String, Object>> result = new ArrayList<>();
			for(Friends fr: frs) {
				 Map<String, Object> data = new HashMap<>();
				 if (fr.getGui().equals(userId)) {
					 data.put("user", userRepository.findById(fr.getNhan()));
					 data.put("mutualFr", 0);
//					   data.put("mutualFr",usImpl.getBanChung(userId, otherUserId));
				 }else {
					 data.put("user", userRepository.findById(fr.getGui()));
					 data.put("mutualFr", 0);
//					   data.put("mutualFr",usImpl.getBanChung(userId, otherUserId));
				 }
				 result.add(data);
			}
			
		
		        return result;
		}
}
