package com.example.quizmakerbackend.service.abstraction;

import com.example.quizmakerbackend.dto.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    List<QuestionResponse> getAllQuestions(Long quizId);

    QuestionResponse getQuestion(Long questionId);

}
