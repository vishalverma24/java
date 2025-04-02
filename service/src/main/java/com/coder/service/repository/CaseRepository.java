package com.coder.service.repository;

import com.coder.service.entity.Case;
import com.coder.service.entity.Doctor;
import com.coder.service.enums.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {
    boolean existsByDoctorAndDateAndSlot(Doctor doctor, LocalDate date, Slot slot);

    List<Case> findByUserId(Long userId);
}
