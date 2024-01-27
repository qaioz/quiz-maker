package com.example.quizmakerbackend.service.abstraction;

import com.example.quizmakerbackend.dto.QuizInput;
import org.springframework.stereotype.Service;

@Service
public interface QuizParser {
    QuizInput parseQuiz(String questions, String title);
}
