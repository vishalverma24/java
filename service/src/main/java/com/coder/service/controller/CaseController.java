package com.coder.service.controller;

import com.coder.service.entity.Case;
import com.coder.service.entity.User;
import com.coder.service.enums.Slot;
import com.coder.service.repository.CaseRepository;
import com.coder.service.repository.UserRepository;
import com.coder.service.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseRepository caseRepository;
    private final UserRepository userRepository;
    private final CaseService caseService;

    @PostMapping("/create")
    public ResponseEntity<Case> createCase(@RequestParam Long userId,
                                           @RequestParam LocalDate date,
                                           @RequestParam Slot slot) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Case newCase = caseService.createCase(user, date, slot);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCase);
    }
}

