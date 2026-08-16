package org.example.backend.security.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message="username is required")
    @Size(min=1,max=100,message = "username must be between 1 and 100 characters")
    private String username;

    @NotBlank(message="password is required")
    private String password;

}
