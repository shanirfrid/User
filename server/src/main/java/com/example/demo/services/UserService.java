package com.example.demo.services;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.RetryableMongoOperation;
import com.example.demo.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @RetryableMongoOperation
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmailAddress(userRequestDTO.getEmailAddress())) {
            throw new UserAlreadyExistsException(
                    String.format("The user %s already exists",userRequestDTO.getEmailAddress()));
        }
        User user =  userRepository
                .save(UserMapper.convertToEntity(userRequestDTO));
        log.info("add user {} {}", userRequestDTO.getFirstName(), userRequestDTO.getLastName());

        return UserMapper.convertToDTO(user);
    }

    @RetryableMongoOperation
    public void deleteUser(String emailAddress) {
        userRepository.deleteById(emailAddress);
        log.info("delete user {}", emailAddress);
    }

    @RetryableMongoOperation
    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
