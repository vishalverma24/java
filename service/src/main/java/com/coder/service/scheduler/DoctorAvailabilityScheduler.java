package com.coder.service.scheduler;

import com.coder.service.entity.Doctor;
import com.coder.service.entity.DoctorAvailability;
import com.coder.service.enums.Slot;
import com.coder.service.repository.DoctorAvailabilityRepository;
import com.coder.service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorAvailabilityScheduler {

    @Autowired
    private DoctorAvailabilityRepository availabilityRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Scheduled(cron = "0 0 0 * * MON") // Runs every Monday at midnight
    public void updateDoctorAvailability() {
        List<Doctor> doctors = doctorRepository.findAll();
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);

        List<DoctorAvailability> availabilities = new ArrayList<>();
        for (Doctor doctor : doctors) {
            for (int i = 0; i < 7; i++) {
                LocalDate date = nextWeek.plusDays(i);
                availabilities.add(new DoctorAvailability(null, doctor, date, Slot.MORNING, true));
                availabilities.add(new DoctorAvailability(null, doctor, date, Slot.EVENING, true));
            }
        }
        availabilityRepository.saveAll(availabilities);
    }
}

