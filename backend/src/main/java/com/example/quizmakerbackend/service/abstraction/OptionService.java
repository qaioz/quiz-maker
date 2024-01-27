package com.example.quizmakerbackend.service.abstraction;

import com.example.quizmakerbackend.domain.Option;
import com.example.quizmakerbackend.dto.OptionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionService {
    List<OptionResponse> getAllOptions(Long questionId);
}
