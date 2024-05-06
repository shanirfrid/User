package com.example.demo.controllers;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.addUser(userRequestDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam String emailAddress) {
        userService.deleteUser(emailAddress);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}

