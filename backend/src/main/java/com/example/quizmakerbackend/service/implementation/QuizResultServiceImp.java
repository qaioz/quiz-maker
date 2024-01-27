package com.example.quizmakerbackend.service.implementation;

import com.example.quizmakerbackend.domain.Quiz;
import com.example.quizmakerbackend.domain.QuizResult;
import com.example.quizmakerbackend.dto.QuizResultInput;
import com.example.quizmakerbackend.dto.QuizResultResponse;
import com.example.quizmakerbackend.mapper.QuizResultMapper;
import com.example.quizmakerbackend.repository.QuizRepository;
import com.example.quizmakerbackend.repository.QuizResultRepository;
import com.example.quizmakerbackend.service.abstraction.QuizResultService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class QuizResultServiceImp implements QuizResultService {
    private final QuizRepository quizRepository;
    private final QuizResultRepository quizResultRepository;
    private final QuizResultMapper quizResultMapper;

    @Transactional
    @Override
    public QuizResultResponse createQuizResult(Long quizId, QuizResultInput quizResultInput) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        QuizResult newQuizResult = quizResultMapper.mapToQuizResult(quizResultInput);
        newQuizResult.setQuiz(quiz);
        quiz.getQuizResults().add(newQuizResult);
        quizRepository.save(quiz);
        return quizResultMapper.mapToQuizResultResponse(newQuizResult);
    }

    @Transactional
    @Override
    public List<QuizResultResponse> getAllQuizResults(Long quizId) {
        if (!quizRepository.existsById(quizId)) {
            throw new NoSuchElementException("Quiz with id " + quizId + " does not exist");
        }
        return quizResultRepository.findAllByQuiz_QuizId(quizId).stream().map(quizResultMapper::mapToQuizResultResponse).toList();
    }
}
