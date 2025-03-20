package com.example.chat.chat_backend.DTO;



import java.util.Date;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinNhanDTO {
    private ObjectId id;
    private ObjectId idRoom;
    private Date thoiGian;
    private String noiDung;
    private String idNguoiGui;
    private String tenNguoiGui;
    private String avtNguoiGui;
    
    
}
