package com.coder.service.service;

import com.coder.service.entity.Case;
import com.coder.service.entity.User;
import com.coder.service.enums.Slot;
import com.coder.service.repository.CaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CaseService {

    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getCasesByUser(Long userId) {
        return caseRepository.findByUserId(userId);
    }

    @Transactional
    public Case createCase(User user, LocalDate date, Slot slot) {
        Case newCase = new Case();
        newCase.setUser(user);
        newCase.setCreatedDate(date);
        newCase.setDoctor(null); // Initially empty

        Case updatedCase = caseRepository.save(newCase);

//        sendNotificationToAvailableDoctors(date, slot);
        return updatedCase;
    }
}
