package com.example.quizmakerbackend.dto;

import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizStringInput {

    private String title;
    @Lob
    private String questions;
}
