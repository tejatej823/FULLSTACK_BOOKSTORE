package org.example.backend.mapper;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="id",ignore = true)
    @Mapping(target="roles",ignore = true)
    Users toEntity(UserRequestDto userRequestDto);

    UserResponseDto toDto(Users user);

}
