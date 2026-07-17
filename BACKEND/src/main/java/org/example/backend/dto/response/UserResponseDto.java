package org.example.backend.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserResponseDto {

    @NotBlank
    private Long id;

    @NotBlank(message="username is required")
    @Size(min=1,max=100,message = "username must be between 1 and 100 characters")
    private String username;

    @NotBlank(message="email is required")
    @Email(message="enter valid email")
    private String email;

    @NotBlank(message="password is required")
    private String password;
}
