package com.coder.service.service;


import com.coder.service.dto.DoctorDto;
import com.coder.service.entity.Doctor;
import com.coder.service.enums.Slot;
import com.coder.service.mapper.DoctorMapper;
import com.coder.service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.toEntity(doctorDto);
        return doctorMapper.toDto(doctorRepository.save(doctor));
    }

    public Optional<DoctorDto> getDoctor(Long id) {
        return doctorRepository.findById(id).map(doctorMapper::toDto);
    }

    public DoctorDto editDoctor(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setName(doctorDto.getName());
        return doctorMapper.toDto(doctorRepository.save(doctor));
    }

    public List<DoctorDto> getAvailableDoctors(LocalDate date, Slot slot) {
        List<Doctor> doctorList = doctorRepository.findByAvailableSlot(date,slot.name());
        return doctorList.stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }
}
