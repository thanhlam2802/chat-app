package com.example.chat.chat_backend.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.chat_backend.Bean.tinNhan;
import com.example.chat.chat_backend.DTO.TinNhanDTO;
import com.example.chat.chat_backend.Service.tinNhanService;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

@RestController
@RequestMapping("/api/messages")
public class ChatMessage {

	@Autowired
	private tinNhanService tinNhanService;
	 @Autowired
	    private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/{idRoom}")
	public List<TinNhanDTO> getMessages(@PathVariable String idRoom) {
		try {
			if (idRoom == null || idRoom.trim().isEmpty()) {
				System.out.println(" ID Room không hợp lệ!");
				return List.of();
			}

			ObjectId roomObjectId = new ObjectId(idRoom);
			List<TinNhanDTO> messages = tinNhanService.getMessagesByRoom(roomObjectId);
			System.out.print(messages);
			if (messages.isEmpty()) {
				System.out.println(" Không có tin nhắn nào trong phòng " + idRoom);
			} else {
				System.out.println(" Lấy được " + messages.size() + " tin nhắn.");
			}

			return messages;
		} catch (Exception e) {
			System.err.println(" Lỗi khi lấy tin nhắn: " + e.getMessage());
			return List.of();
		}
	}
	@PostMapping("/send")
    public String sendMessage(@RequestBody tinNhan tinNhan) {
        try {
        	tinNhan.setThoiGian(new Date());

            tinNhan savedMessage = tinNhanService.create(tinNhan);

          
            messagingTemplate.convertAndSend("/topic/chat/" + tinNhan.getIdRoom(), tinNhan);

            System.out.println("Đã gửi tin nhắn: " + tinNhan.getNoiDung());
            return "Tin nhắn đã được gửi!";
        } catch (Exception e) {
            System.err.println("Lỗi khi gửi tin nhắn: " + e.getMessage());
            return "Lỗi khi gửi tin nhắn!";
        }
    }

}
