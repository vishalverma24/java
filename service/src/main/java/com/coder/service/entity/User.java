package com.coder.service.entity;

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
    private int age;
    private double height;
    private double weight;
    private String diseases;
    private String allergies;
    private String deficiencies;
    private String testReports;

    @OneToMany(mappedBy = "user")
    private List<Case> cases;
}
