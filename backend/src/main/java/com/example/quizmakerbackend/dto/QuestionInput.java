package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class QuestionInput {
    private String content;
    private List<OptionInput> options;
}
