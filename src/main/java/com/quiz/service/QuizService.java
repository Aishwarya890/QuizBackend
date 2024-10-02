package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getScheduledQuizzes() {
        String currentDate = LocalDate.now().toString(); // Use proper date formatting
        return quizRepository.findByDeadlineAfter(currentDate);
    }
    
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }
    
    public Quiz getQuizById(Long id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        return optionalQuiz.orElse(null); // Return the quiz if found, otherwise return null
    }
    
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
