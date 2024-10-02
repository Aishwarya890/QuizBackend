package com.quiz.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String deadline; 
    private List<String> correctAnswers;
    @ElementCollection
    private List<String> questions;

    @ElementCollection
    private List<List<String>> options; // List of options for each question

}

