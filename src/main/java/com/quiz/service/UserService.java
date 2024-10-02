package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.entity.User;
import com.quiz.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public User register(User user) {
//        return userRepository.save(user);
//    }
    public ResponseEntity<String> registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists.");
        }

        userRepository.save(user);
        return ResponseEntity.ok("Registration successful!");
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User save(User registrationDto) {
        // Create a new User entity
        User user = new User();
        user.setFullName(registrationDto.getFullName());
        user.setEmail(registrationDto.getEmail());
        user.setRole(registrationDto.getRole());

        // Save the user to the database
        return userRepository.save(user);
    }
}
