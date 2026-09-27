package com.coder.service.repository;

import com.coder.service.entity.Doctor;
import com.coder.service.enums.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT DISTINCT a.doctor FROM DoctorAvailability a " +
            "WHERE a.date = :date AND a.slot = :slot AND a.isAvailable = true")
    List<Doctor> findByAvailableSlot(@Param("date") LocalDate date, @Param("slot") Slot slot);
}
