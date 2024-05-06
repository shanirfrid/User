package com.example.demo.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "users")
public class User {
    @Id
    @Indexed(unique = true)
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;
}
