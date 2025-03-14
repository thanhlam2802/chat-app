package com.example.chat.chat_backend.Bean;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "tinNhan")
public class tinNhan {
    @Id
    private ObjectId id;
    private String idNguoiGui; 
    private String noiDung;    
    private Date thoiGian;    
    private String idRoom;     
    private String file; 

}
