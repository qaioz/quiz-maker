package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.dto.OptionInput;
import com.example.quizmakerbackend.dto.OptionResponse;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {
    public Option mapToOption(OptionInput optionInput) {
        Option option = new Option();
        option.setContent(optionInput.getContent());
        option.setCorrect(optionInput.isCorrect());
        return option;
    }

    public OptionResponse mapToOptionResponse(Option option) {
        OptionResponse optionResponse = new OptionResponse();
        optionResponse.setId(option.getId());
        optionResponse.setContent(option.getContent());
        optionResponse.setCorrect(option.isCorrect());
        return optionResponse;
    }
}
