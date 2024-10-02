package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin/quizzes")
public class AdminQuizController {
    @Autowired
    private QuizService quizService;

    
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        try {
            Quiz createdQuiz = quizService.save(quiz);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz); // Return 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 in case of error
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        try {
            List<Quiz> quizzes = quizService.findAll();
            return ResponseEntity.ok(quizzes); // Return 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 in case of error
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
    
    
}

