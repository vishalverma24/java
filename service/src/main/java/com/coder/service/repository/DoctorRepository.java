package com.coder.service.repository;

import com.coder.service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByAvailableSlot(LocalDate date, String slot);
}
