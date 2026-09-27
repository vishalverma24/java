package com.coder.service.mapper;

import com.coder.service.dto.UserDto;
import com.coder.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cases", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cases", ignore = true)
    void updateEntity(UserDto userDto, @MappingTarget User user);
}
