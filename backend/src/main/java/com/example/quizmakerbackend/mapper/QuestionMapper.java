package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.domain.Question;
import com.example.quizmakerbackend.dto.QuestionInput;
import com.example.quizmakerbackend.dto.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {
    private final OptionMapper optionMapper;

    @Autowired
    public QuestionMapper(OptionMapper optionMapper) {
        this.optionMapper = optionMapper;
    }

    public Question mapToQuestion(QuestionInput questionInput) {
        Question question = new Question();
        question.setContent(questionInput.getContent());
        List<Option> options = questionInput.getOptions().stream()
                .map(optionMapper::mapToOption)
                .toList();
        options.forEach(option -> option.setQuestion(question));
        question.setOptions(options);
        return question;
    }

    public QuestionResponse mapToQuestionResponse(Question question) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId(question.getId());
        questionResponse.setContent(question.getContent());
        questionResponse.setOptions(question.getOptions().stream()
                .map(optionMapper::mapToOptionResponse)
                .toList());
        return questionResponse;
    }
}
