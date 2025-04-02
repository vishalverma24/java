package com.coder.service.repository;

import com.coder.service.entity.DoctorAvailability;
import com.coder.service.enums.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    List<DoctorAvailability> findByDateAndSlotAndIsAvailableTrue(LocalDate date, Slot slot);
}

