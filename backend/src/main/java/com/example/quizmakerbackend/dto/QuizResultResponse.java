package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuizResultResponse {
    private Long quizResultId;

    private String nickname;

    private int score;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
