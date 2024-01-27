package com.example.quizmakerbackend.mapper;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.domain.Question;
import com.example.quizmakerbackend.dto.OptionInput;
import com.example.quizmakerbackend.dto.OptionResponse;
import com.example.quizmakerbackend.dto.QuestionInput;
import com.example.quizmakerbackend.dto.QuestionResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuestionMapperTest {

    @Mock
    private OptionMapper optionMapper;

    @InjectMocks
    private QuestionMapper questionMapper;

    @Test
    public void mapToQuestionTest() {
        OptionInput optionInput = new OptionInput();
        optionInput.setContent("Test Content");
        optionInput.setCorrect(true);
        List<OptionInput> optionInputs = List.of(optionInput);

        QuestionInput questionInput = new QuestionInput();
        questionInput.setContent("Test Question");
        questionInput.setOptions(optionInputs);

        Option option = new Option();
        option.setContent(optionInput.getContent());
        option.setCorrect(optionInput.isCorrect());

        when(optionMapper.mapToOption(optionInput)).thenReturn(option);

        Question question = questionMapper.mapToQuestion(questionInput);

        assertEquals(questionInput.getContent(), question.getContent());
        assertEquals(optionInput.getContent(), question.getOptions().get(0).getContent());
        assertEquals(optionInput.isCorrect(), question.getOptions().get(0).isCorrect());
    }

    @Test
    public void mapToQuestionResponseTest() {
        Option option = new Option();
        option.setId(1L);
        option.setContent("Test Content");
        option.setCorrect(true);
        List<Option> options = List.of(option);

        Question question = new Question();
        question.setId(1L);
        question.setContent("Test Question");
        question.setOptions(options);

        OptionResponse optionResponse = new OptionResponse();
        optionResponse.setId(option.getId());
        optionResponse.setContent(option.getContent());
        optionResponse.setCorrect(option.isCorrect());

        when(optionMapper.mapToOptionResponse(option)).thenReturn(optionResponse);

        QuestionResponse questionResponse = questionMapper.mapToQuestionResponse(question);

        assertEquals(question.getId(), questionResponse.getId());
        assertEquals(question.getContent(), questionResponse.getContent());
        assertEquals(optionResponse.getId(), questionResponse.getOptions().get(0).getId());
        assertEquals(optionResponse.getContent(), questionResponse.getOptions().get(0).getContent());
        assertEquals(optionResponse.isCorrect(), questionResponse.getOptions().get(0).isCorrect());
    }
}
