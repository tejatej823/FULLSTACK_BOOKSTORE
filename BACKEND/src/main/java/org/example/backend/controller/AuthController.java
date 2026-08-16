package org.example.backend.controller;
import jakarta.validation.Valid;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.security.dto.LoginRequestDto;
import org.example.backend.service.UserService;
import org.example.backend.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;

    private final UserService userService;


    @Autowired
    AuthController(AuthenticationManager authenticationManager, UserService userService){
        this.authenticationManager = authenticationManager;
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
    public String loginUser(@RequestBody LoginRequestDto request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return "user success" + userDetails.getUsername();
    }

}
