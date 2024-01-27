package com.example.quizmakerbackend.service.implementation;

import com.example.quizmakerbackend.dto.QuestionResponse;
import com.example.quizmakerbackend.mapper.QuestionMapper;
import com.example.quizmakerbackend.repository.QuestionRepository;
import com.example.quizmakerbackend.service.abstraction.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class QuestionServiceImp implements QuestionService{
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImp(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionResponse> getAllQuestions(Long quizId) {
        if(!questionRepository.existsById(quizId)){
            throw new NoSuchElementException("Quiz with id " + quizId + " does not exist");
        }
        return questionRepository.findAllByQuiz_QuizId(quizId).stream().map(questionMapper::mapToQuestionResponse).toList();

    }

    @Override
    public QuestionResponse getQuestion(Long questionId) {
        if(!questionRepository.existsById(questionId)){
            throw new NoSuchElementException("Question with id " + questionId + " does not exist");
        }
        return questionMapper.mapToQuestionResponse(questionRepository.findById(questionId).orElseThrow());
    }
}
