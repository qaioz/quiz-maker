package com.example.quizmakerbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionResponse {

    private Long id;
    private String content;

    private boolean correct;


}
