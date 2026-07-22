package org.example.backend.mapper;
import org.example.backend.dto.request.UserRequestDto;
import org.example.backend.dto.response.UserResponseDto;
import org.example.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target="id",ignore = true)
    @Mapping(target="roles",ignore = true)
    User toEntity(UserRequestDto userRequestDto);

    UserResponseDto toDto(User user);

}
