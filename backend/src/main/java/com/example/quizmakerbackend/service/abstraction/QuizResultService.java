package com.example.quizmakerbackend.service.abstraction;

import com.example.quizmakerbackend.dto.QuizResultInput;
import com.example.quizmakerbackend.dto.QuizResultResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizResultService {
    QuizResultResponse createQuizResult(Long quizId, QuizResultInput quizResultInput);
    List<QuizResultResponse> getAllQuizResults(Long quizId);
}
