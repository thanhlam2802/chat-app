package com.example.chat.chat_backend.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
