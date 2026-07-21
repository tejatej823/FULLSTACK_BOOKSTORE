package org.example.backend.service;

import jakarta.transaction.Transactional;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {

        if(userRepository.existsByEmail(userRequestDto.getEmail())){
            throw new IllegalArgumentException("Email is already registered!");
        }

        if(userRepository.existsByUsername(userRequestDto.getUsername())){
            throw new IllegalArgumentException("Username already registered!");
        }


        return null;
    }
}
