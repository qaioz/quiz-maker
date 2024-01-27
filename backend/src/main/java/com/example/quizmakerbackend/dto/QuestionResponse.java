package com.example.quizmakerbackend.dto;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.domain.Quiz;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionResponse {

        private Long id;

        private String content;

        private List<OptionResponse> options;
}
