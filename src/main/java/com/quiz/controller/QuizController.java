package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.entity.QuizSubmissionRequest;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import com.quiz.service.UserAnswersService;
import com.quiz.service.QuizService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/teacher/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;
    
    @PostMapping
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz) {
        try {
            Quiz createdQuiz = quizService.save(quiz);
            return ResponseEntity.ok(createdQuiz);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create quiz: " + e.getMessage());
        }
    }


//    @GetMapping
//    public List<Quiz> getScheduledQuizzes() {
//        return quizService.getScheduledQuizzes();
//    }
    @GetMapping
    public ResponseEntity<List<Quiz>> getScheduledQuizzes() {
        List<Quiz> quizzes = quizService.getScheduledQuizzes();
        if (quizzes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(quizzes);
    }
    
    @Autowired
    private UserAnswersService userAnswersService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody QuizSubmissionRequest request) {
        // Assuming you have a user ID mechanism (e.g., from session or JWT)
        String userId = "currentUserId"; // Replace this with actual user ID logic

        userAnswersService.saveAnswers(request.getQuizId(), userId, request.getAnswers());
        return ResponseEntity.ok("Quiz submitted successfully");
    }
    
   
    

    
}
