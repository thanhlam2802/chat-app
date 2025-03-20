package com.example.chat.chat_backend.Bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "friends")
public class Friends {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;  

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId gui;  

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId nhan;  

    private boolean status;
}
