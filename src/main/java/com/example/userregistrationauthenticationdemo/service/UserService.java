package com.example.userregistrationauthenticationdemo.service;

import com.example.userregistrationauthenticationdemo.dto.UserDto;
import com.example.userregistrationauthenticationdemo.entity.User;
import com.example.userregistrationauthenticationdemo.exception.UserAlreadyExistsException;
import com.example.userregistrationauthenticationdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User register(UserDto userDto) throws UserAlreadyExistsException {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь с таким email уже существует!");
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}
