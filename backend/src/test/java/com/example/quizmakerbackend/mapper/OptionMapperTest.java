package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.dto.OptionInput;
import com.example.quizmakerbackend.dto.OptionResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OptionMapperTest {

    @InjectMocks
    private OptionMapper optionMapper;

    @Test
    public void mapToOptionTest() {
        OptionInput optionInput = new OptionInput();
        optionInput.setContent("Test Content");
        optionInput.setCorrect(true);
        Option option = optionMapper.mapToOption(optionInput);
        assertEquals(optionInput.getContent(), option.getContent());
        assertEquals(optionInput.isCorrect(), option.isCorrect());
    }

    @Test
    public void mapToOptionResponseTest() {
        Option option = new Option();
        option.setId(1L);
        option.setContent("Test Content");
        option.setCorrect(true);
        OptionResponse optionResponse = optionMapper.mapToOptionResponse(option);
        assertEquals(option.getId(), optionResponse.getId());
        assertEquals(option.getContent(), optionResponse.getContent());
        assertEquals(option.isCorrect(), optionResponse.isCorrect());
    }

}
