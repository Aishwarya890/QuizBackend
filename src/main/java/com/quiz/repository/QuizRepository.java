package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByDeadlineAfter(String currentDate);
}
