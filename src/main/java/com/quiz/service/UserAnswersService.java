package com.quiz.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.UserAnswers;
import com.quiz.repository.UserAnswersRepository;

@Service
public class UserAnswersService {

 @Autowired
 private UserAnswersRepository userAnswersRepository;

 public UserAnswers saveAnswers(Long quizId, String userId, List<String> answers) {
     UserAnswers userAnswers = new UserAnswers();
     userAnswers.setQuizId(quizId);
     userAnswers.setUserId(userId);
     userAnswers.setAnswers(answers);
     return userAnswersRepository.save(userAnswers);
 }
}
