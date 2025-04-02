package com.coder.service.mapper;

import com.coder.service.dto.DoctorDto;
import com.coder.service.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "userIds", expression = "java(doctor.getUsers().stream().map(com.example.userapi.entity.User::getId).collect(java.util.stream.Collectors.toSet()))")
    DoctorDto toDto(Doctor doctor);

    @Mapping(target = "users", ignore = true)
    Doctor toEntity(DoctorDto doctorDto);
}
