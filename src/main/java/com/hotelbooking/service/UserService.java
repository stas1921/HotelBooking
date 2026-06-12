package com.hotelbooking.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotelbooking.entity.User;
import com.hotelbooking.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User register(User user) {
        return userRepository.save(user);
    }
}