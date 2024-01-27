package com.example.quizmakerbackend.repository;

import com.example.quizmakerbackend.domain.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    List<QuizResult> findAllByQuiz_QuizId(Long quizId);
}
