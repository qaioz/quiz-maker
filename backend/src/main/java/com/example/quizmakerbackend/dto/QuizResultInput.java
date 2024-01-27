package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuizResultInput {
    private String nickname;
    private int score;
    private LocalDateTime startedAt;
}
