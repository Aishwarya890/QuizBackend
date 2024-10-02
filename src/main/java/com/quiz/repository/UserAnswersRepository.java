package com.quiz.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.UserAnswers;

public interface UserAnswersRepository extends JpaRepository<UserAnswers, Long> {
 // You can define custom query methods here if needed
}

