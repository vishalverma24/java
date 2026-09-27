package com.coder.service.service;

import com.coder.service.dto.UserDto;
import com.coder.service.entity.User;
import com.coder.service.mapper.UserMapper;
import com.coder.service.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    public Optional<UserDto> getUser(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    public UserDto editUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userMapper.updateEntity(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }
}
