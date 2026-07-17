package org.example.backend.service;

import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;

public interface UserService {
    public UserResponseDto saveUser(UserRequestDto userRequestDto);
}
