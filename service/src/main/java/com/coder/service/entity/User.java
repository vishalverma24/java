package com.coder.service.entity;

import com.coder.service.converter.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Double height;
    private Double weight;

    @Convert(converter = StringListConverter.class)
    private List<String> diseases;

    @Convert(converter = StringListConverter.class)
    private List<String> allergies;

    @Convert(converter = StringListConverter.class)
    private List<String> deficiencies;

    @Convert(converter = StringListConverter.class)
    private List<String> testReports;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Case> cases;
}
