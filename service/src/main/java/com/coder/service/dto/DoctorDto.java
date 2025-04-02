package com.coder.service.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class DoctorDto {
    private String name;
    private Integer age;
    private String gender;
    private String degree;
    private Set<Long> userIds;
}
