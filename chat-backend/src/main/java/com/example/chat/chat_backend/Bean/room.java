package com.example.chat.chat_backend.Bean;

import java.util.List;

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
@Document(collection = "room")
public class room {
    @Id
    private ObjectId id;
    private List<ObjectId> members; 
    private boolean type;        
    private String name;   
}
