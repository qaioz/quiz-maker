package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.QuizResult;
import com.example.quizmakerbackend.dto.QuizResultInput;
import com.example.quizmakerbackend.dto.QuizResultResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QuizResultMapper {
    public QuizResult mapToQuizResult(QuizResultInput quizResultInput) {
        QuizResult quizResult = new QuizResult();
        quizResult.setNickname(quizResultInput.getNickname());
        quizResult.setScore(quizResultInput.getScore());
        quizResult.setStartedAt(quizResultInput.getStartedAt());
        quizResult.setFinishedAt(LocalDateTime.now());
        return quizResult;
    }

    public QuizResultResponse mapToQuizResultResponse(QuizResult quizResult) {
        QuizResultResponse quizResultResponse = new QuizResultResponse();
        quizResultResponse.setQuizResultId(quizResult.getQuizResultId());
        quizResultResponse.setNickname(quizResult.getNickname());
        quizResultResponse.setScore(quizResult.getScore());
        quizResultResponse.setStartedAt(quizResult.getStartedAt());
        quizResultResponse.setFinishedAt(quizResult.getFinishedAt());
        return quizResultResponse;
    }

}
