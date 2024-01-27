package com.example.quizmakerbackend.config;

import com.example.quizmakerbackend.mapper.OptionMapper;
import com.example.quizmakerbackend.mapper.QuestionMapper;
import com.example.quizmakerbackend.mapper.QuizMapper;
import com.example.quizmakerbackend.mapper.QuizResultMapper;
import com.example.quizmakerbackend.repository.OptionRepository;
import com.example.quizmakerbackend.repository.QuestionRepository;
import com.example.quizmakerbackend.repository.QuizRepository;
import com.example.quizmakerbackend.repository.QuizResultRepository;
import com.example.quizmakerbackend.service.abstraction.OptionService;
import com.example.quizmakerbackend.service.abstraction.QuestionService;
import com.example.quizmakerbackend.service.abstraction.QuizResultService;
import com.example.quizmakerbackend.service.abstraction.QuizService;
import com.example.quizmakerbackend.service.implementation.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor

public class Config {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final OptionRepository optionRepository;
    private final OptionMapper optionMapper;
    private final QuizResultRepository quizResultRepository;
    private final QuizResultMapper quizResultMapper;
    @Autowired
    private final SimpleQuizParser quizParser;

    @Bean
    public QuizService quizService() {
        return new QuizServiceImp(quizRepository, quizMapper, quizParser);
    }

    @Bean
    public QuestionService questionService() {
        return new QuestionServiceImp(questionRepository, questionMapper);
    }

    @Bean
    public OptionService optionService() {
        return new OptionServiceImp(optionRepository, optionMapper);
    }

    @Bean
    public QuizResultService quizResultService() {
        return new QuizResultServiceImp(quizRepository, quizResultRepository, quizResultMapper);
    }


    

}
