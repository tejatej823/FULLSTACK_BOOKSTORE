package org.example.backend.service;
import jakarta.transaction.Transactional;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.mapper.UserMapper;
import org.example.backend.model.ERole;
import org.example.backend.model.Role;
import org.example.backend.model.User;
import org.example.backend.repository.RoleRepository;
import org.example.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    PasswordEncoder encoder=new BCryptPasswordEncoder();

    UserServiceImpl(UserRepository userRepository,UserMapper userMapper,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
        this.roleRepository=roleRepository;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {

        if(userRepository.existsByEmail(userRequestDto.getEmail())){
            throw new IllegalArgumentException("Email is already registered!");
        }

        if(userRepository.existsByUsername(userRequestDto.getUsername())){
            throw new IllegalArgumentException("Username already registered!");
        }

        User user=userMapper.toEntity(userRequestDto);
        Role role=roleRepository.findByRole(ERole.ROLE_USER);
        Set<Role>roles=new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);

    }
}
