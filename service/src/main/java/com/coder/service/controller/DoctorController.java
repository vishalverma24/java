package com.coder.service.controller;

import com.coder.service.dto.DoctorDto;
import com.coder.service.enums.Slot;
import com.coder.service.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> postDoctor(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctorDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long id) {
        Optional<DoctorDto> doctorDto = doctorService.getDoctor(id);
        return doctorDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> editDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.editDoctor(id, doctorDto));
    }

    @GetMapping("/available")
    public List<DoctorDto> getAvailableDoctors(@RequestParam LocalDate date, @RequestParam Slot slot) {
        return doctorService.getAvailableDoctors(date, slot);
    }
}
