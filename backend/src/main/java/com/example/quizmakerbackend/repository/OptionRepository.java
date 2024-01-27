package com.example.quizmakerbackend.repository;

import com.example.quizmakerbackend.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByQuestion_Id(Long questionId);
}
