package com.coder.service.entity;

import com.coder.service.enums.Slot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "doctor_availability")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Slot slot; // Slot Enum (MORNING, EVENING)

    private boolean isAvailable;
}

