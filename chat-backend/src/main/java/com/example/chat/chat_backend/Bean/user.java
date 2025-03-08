package com.example.chat.chat_backend.Bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class user {
    @Id
    private String id;
    private String name;
    private String pass;
    private Date timeLog;
    private boolean status;
    private String avt;
    
}