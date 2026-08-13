package org.example.backend.controller;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.model.User;
import org.example.backend.service.UserService;
import org.example.backend.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final UserService userService;

    @Autowired
    AuthController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequestDto userRequestDto){

        UserResponseDto userResponseDto=userService.saveUser(userRequestDto);
        System.out.println(userResponseDto.getUsername());
        ApiResponse<UserResponseDto> response=new ApiResponse<>(true,"User registered successfully",userResponseDto);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(){

        return null;
    }

}
