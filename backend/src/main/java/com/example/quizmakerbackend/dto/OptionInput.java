package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OptionInput {
    private String content;
    private boolean correct;
}
