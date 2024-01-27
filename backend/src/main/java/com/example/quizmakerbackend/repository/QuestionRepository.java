package com.example.quizmakerbackend.repository;

import com.example.quizmakerbackend.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByQuiz_QuizId(Long quizId);
}
