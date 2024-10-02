package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.entity.User;
import com.quiz.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;


    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return userService.registerUser(user);
    }

}


