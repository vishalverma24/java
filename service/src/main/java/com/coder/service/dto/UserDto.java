package com.coder.service.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDto {
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private List<String> diseases;
    private List<String> allergies;
    private List<String> deficiencies;
    private List<String> testReports;
}
