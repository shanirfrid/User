package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDTO {
    @NotBlank(message = "First name shouldn't be NULL OR EMPTY")
    private String firstName;
    @NotBlank(message = "Last name shouldn't be NULL OR EMPTY")
    private String lastName;
    @Email(message = "Please provide a valid email address")
    private String emailAddress;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
