package com.coder.service.mapper;

import com.coder.service.dto.DoctorDto;
import com.coder.service.entity.Case;
import com.coder.service.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "userIds", source = "cases")
    DoctorDto toDto(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "availabilities", ignore = true)
    @Mapping(target = "cases", ignore = true)
    Doctor toEntity(DoctorDto doctorDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "availabilities", ignore = true)
    @Mapping(target = "cases", ignore = true)
    void updateEntity(DoctorDto doctorDto, @MappingTarget Doctor doctor);

    default Set<Long> casesToUserIds(List<Case> cases) {
        if (cases == null) {
            return Set.of();
        }
        return cases.stream()
                .map(Case::getUser)
                .filter(Objects::nonNull)
                .map(user -> user.getId())
                .collect(Collectors.toSet());
    }
}
