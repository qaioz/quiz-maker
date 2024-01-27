package com.example.quizmakerbackend.service.abstraction;

import com.example.quizmakerbackend.domain.Quiz;
import com.example.quizmakerbackend.dto.QuizInput;
import com.example.quizmakerbackend.dto.QuizResponse;
import com.example.quizmakerbackend.dto.QuizStringInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    QuizResponse createQuiz(QuizInput quizInput);

    QuizResponse getQuiz(Long id);

    List<QuizResponse> getAllQuizzes();

    void deleteQuiz(Long id);

    QuizResponse createFromString(QuizStringInput quizStringInput);
}
