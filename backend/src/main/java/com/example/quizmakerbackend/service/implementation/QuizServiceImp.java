package com.example.quizmakerbackend.service.implementation;

import com.example.quizmakerbackend.domain.Quiz;
import com.example.quizmakerbackend.dto.QuizInput;
import com.example.quizmakerbackend.dto.QuizResponse;
import com.example.quizmakerbackend.dto.QuizStringInput;
import com.example.quizmakerbackend.mapper.QuizMapper;
import com.example.quizmakerbackend.repository.QuizRepository;
import com.example.quizmakerbackend.service.abstraction.QuizParser;
import com.example.quizmakerbackend.service.abstraction.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class QuizServiceImp implements QuizService{

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final QuizParser quizParser;

    @Autowired
    public QuizServiceImp(QuizRepository quizRepository, QuizMapper quizMapper, QuizParser quizParser) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
        this.quizParser = quizParser;
    }

    @Override
    @Transactional
    public QuizResponse createQuiz(QuizInput quizInput) {
        Quiz quiz = quizMapper.mapToQuiz(quizInput);
        return quizMapper.mapToQuizResponse(quizRepository.save(quiz));
    }

    @Override
    public QuizResponse getQuiz(Long id) {
        Optional<Quiz> byId = quizRepository.findById(id);
        return byId.map(quizMapper::mapToQuizResponse).orElseThrow();
    }

    @Override
    public List<QuizResponse> getAllQuizzes() {
        return quizRepository.findAll().stream().map(quizMapper::mapToQuizResponse).toList();
    }

    @Override
    @Transactional
    public void deleteQuiz(Long id) {
        if(!quizRepository.existsById(id)){
            throw new NoSuchElementException("Quiz with id " + id + " does not exist");
        }
        quizRepository.deleteById(id);
    }

    @Override
    public QuizResponse createFromString(QuizStringInput quizStringInput) {
        String title = quizStringInput.getTitle();
        String questions = quizStringInput.getQuestions();
        QuizInput quizInput = quizParser.parseQuiz(questions, title);
        Quiz quiz = quizMapper.mapToQuiz(quizInput);
        return quizMapper.mapToQuizResponse(quizRepository.save(quiz));
    }
}
