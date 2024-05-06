package com.example.demo.utils;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {

    public static User convertToEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .emailAddress(userRequestDTO.getEmailAddress())
                .password(BCrypt.hashpw(userRequestDTO.getPassword(), BCrypt.gensalt())).build();
    }

    public static UserResponseDTO convertToDTO(User user) {
        return UserResponseDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .build();
    }
}