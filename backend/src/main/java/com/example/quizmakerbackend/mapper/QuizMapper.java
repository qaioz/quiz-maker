package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.Question;
import com.example.quizmakerbackend.domain.Quiz;
import com.example.quizmakerbackend.dto.QuizInput;
import com.example.quizmakerbackend.dto.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class QuizMapper {
    private final QuestionMapper questionMapper;
    private final QuizResultMapper quizResultMapper;

    @Autowired
    public QuizMapper(QuestionMapper questionMapper, QuizResultMapper quizResultMapper) {
        this.questionMapper = questionMapper;
        this.quizResultMapper = quizResultMapper;
    }

    public Quiz mapToQuiz(QuizInput quizInput) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizInput.getTitle());
        quiz.setCreatedAt(LocalDateTime.now());
        List<Question> questions = quizInput.getQuestions().stream()
                .map(questionMapper::mapToQuestion)
                .toList();
        questions.forEach(question -> question.setQuiz(quiz));
        quiz.setQuestions(questions);
        return quiz;
    }

    public QuizResponse mapToQuizResponse(Quiz quiz) {
        QuizResponse quizResponse = new QuizResponse();
        quizResponse.setQuizId(quiz.getQuizId());
        quizResponse.setTitle(quiz.getTitle());
        quizResponse.setCreatedAt(quiz.getCreatedAt());
        quizResponse.setQuestions(quiz.getQuestions().stream()
                .map(questionMapper::mapToQuestionResponse)
                .toList());
        quizResponse.setQuizResults(quiz.getQuizResults().stream().map(quizResultMapper::mapToQuizResultResponse).toList());
        return quizResponse;
    }
}
