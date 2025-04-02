package com.coder.service.service;

import com.coder.service.dto.UserDto;
import com.coder.service.entity.Doctor;
import com.coder.service.entity.User;
import com.coder.service.mapper.UserMapper;
import com.coder.service.repository.DoctorRepository;
import com.coder.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, DoctorRepository doctorRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        if (userDto.getDoctorIds() != null) {
            Set<Doctor> doctors = doctorRepository.findAllById(userDto.getDoctorIds()).stream().collect(Collectors.toSet());
            user.setDoctors(doctors);
        }
        return userMapper.toDto(userRepository.save(user));
    }

    public Optional<UserDto> getUser(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    public UserDto editUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setDiseases(userDto.getDiseases());
        user.setAllergies(userDto.getAllergies());
        user.setDeficiencies(userDto.getDeficiencies());
        user.setTestReports(userDto.getTestReports());
        
        if (userDto.getDoctorIds() != null) {
            Set<Doctor> doctors = doctorRepository.findAllById(userDto.getDoctorIds()).stream().collect(Collectors.toSet());
            user.setDoctors(doctors);
        }

        return userMapper.toDto(userRepository.save(user));
    }
}
