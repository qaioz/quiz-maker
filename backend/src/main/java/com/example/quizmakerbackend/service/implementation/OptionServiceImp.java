package com.example.quizmakerbackend.service.implementation;

import com.example.quizmakerbackend.dto.OptionResponse;
import com.example.quizmakerbackend.mapper.OptionMapper;
import com.example.quizmakerbackend.repository.OptionRepository;
import com.example.quizmakerbackend.service.abstraction.OptionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class OptionServiceImp implements OptionService{

    private final OptionRepository optionRepository;
    private final OptionMapper optionMapper;

    @Autowired
    public OptionServiceImp(OptionRepository optionRepository, OptionMapper optionMapper) {
        this.optionRepository = optionRepository;
        this.optionMapper = optionMapper;
    }

    @Override
    public List<OptionResponse> getAllOptions(Long questionId) {
        if(!optionRepository.existsById(questionId)){
            throw new NoSuchElementException("Question with id " + questionId + " does not exist");
        }
        return optionRepository.findAllByQuestion_Id(questionId).stream().map(optionMapper::mapToOptionResponse).toList();
    }
}
