package com.example.quizmakerbackend.controller;

import com.example.quizmakerbackend.dto.*;
import com.example.quizmakerbackend.service.abstraction.QuestionService;
import com.example.quizmakerbackend.service.abstraction.QuizResultService;
import com.example.quizmakerbackend.service.abstraction.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.quizmakerbackend.dto.QuizStringInput;
import org.springframework.http.HttpHeaders;
import java.util.List;

@CrossOrigin( origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/quiz")
@RequiredArgsConstructor
@Tag(name = "Quiz", description = "Very simple CRUD for quizzes")
public class QuizController {

    private final QuizService quizService;
    private final QuestionService questionService;
    private final QuizResultService quizResultService;

    @PostMapping
    @Operation
    public ResponseEntity<QuizResponse> createQuiz(@RequestBody QuizStringInput quizStringInput) {
        return new ResponseEntity<>(quizService.createFromString(quizStringInput), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation
    public ResponseEntity<List<QuizResponse>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @DeleteMapping("/{id}")
    @Operation
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Operation
    public ResponseEntity<QuizResponse> getQuiz(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuiz(id));
    }

    @GetMapping("/{id}/questions")
    @Operation
    public ResponseEntity<List<QuestionResponse>> getQuestions(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getAllQuestions(id));
    }

    @PostMapping("/{id}/quizresults")
    @Operation
    public ResponseEntity<QuizResultResponse> addQuizResult(@PathVariable Long id, @RequestBody QuizResultInput quizResultInput) {

        return new ResponseEntity<>(quizResultService.createQuizResult(id, quizResultInput),HttpStatus.CREATED);
    }

    @GetMapping("/{id}/quizresults")
    @Operation
    public ResponseEntity<List<QuizResultResponse>> getQuizResults(@PathVariable Long id) {
        return ResponseEntity.ok(quizResultService.getAllQuizResults(id));
    }
}
