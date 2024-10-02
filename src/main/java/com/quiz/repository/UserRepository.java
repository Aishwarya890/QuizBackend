package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
