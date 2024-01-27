package com.example.quizmakerbackend.repository;

import com.example.quizmakerbackend.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
