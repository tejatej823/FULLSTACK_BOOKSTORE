package org.example.backend.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message="username is required")
    @Size(min=1,max=100,message = "username must be between 1 and 100 characters")
    private String username;

    @NotBlank(message="email is required")
    @Email(message="enter valid email")
    private String email;

    @NotBlank(message="password is required")
    private String password;

    private Set<String>roles;

}
