package com.coder.service.mapper;

import com.coder.service.dto.UserDto;
import com.coder.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "doctorIds", expression = "java(user.getDoctors().stream().map(com.example.userapi.entity.Doctor::getId).collect(java.util.stream.Collectors.toSet()))")
    UserDto toDto(User user);

    @Mapping(target = "doctors", ignore = true)
    User toEntity(UserDto userDto);
}
