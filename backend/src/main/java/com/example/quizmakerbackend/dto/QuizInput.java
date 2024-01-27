package com.example.quizmakerbackend.dto;

import com.example.quizmakerbackend.domain.Question;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class QuizInput {
    private String title;
    private List<QuestionInput> questions;
}
