package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class QuizResponse {
    private Long quizId;

    private String title;

    private LocalDateTime createdAt;

    private List<QuestionResponse> questions;

    private List<QuizResultResponse> quizResults;

}
