package com.coder.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Double weight;
    private List<String> diseases;
    private List<String> allergies;
    private List<String> deficiencies;
    private List<String> testReports;
}
