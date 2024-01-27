package com.example.quizmakerbackend.service.implementation;

import com.example.quizmakerbackend.dto.OptionInput;
import com.example.quizmakerbackend.dto.QuestionInput;
import com.example.quizmakerbackend.dto.QuizInput;
import com.example.quizmakerbackend.exception.IllegalFormatException;
import com.example.quizmakerbackend.service.abstraction.QuizParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [Q] Who is ...
 * asda,asdasd,adad,asdad*
 * [Q] when was....
 * 1239,1233*,1111
 */


 @org.springframework.stereotype.Service

public class SimpleQuizParser implements QuizParser {
    public QuizInput parseQuiz(String input, String title) {
        QuizInput quiz = new QuizInput();
        String[] lines = Arrays.stream(input.split("\n")).filter(line -> !line.isBlank()).toArray(String[]::new);
        quiz.setTitle(title);

        List<QuestionInput> questions = new ArrayList<>();
        for (int i = 0; i < lines.length; i += 2) {
            QuestionInput question = new QuestionInput();
            if (!lines[i].trim().startsWith("[Q]")) {
                throw new IllegalFormatException("Question must start with [Q]");
            }
            String content = lines[i].substring(3).trim();
            if (content.isEmpty()) {
                throw new IllegalFormatException("Question content cannot be empty");
            }
            question.setContent(content);
            List<OptionInput> options = new ArrayList<>();
            if(i + 1 >= lines.length) {
                throw new IllegalFormatException("Question must have at least 2 option");
            }
            String[] optionStrings = lines[i + 1].split(";");
            System.out.println(lines[i + 1]);
            for (String optionString : optionStrings) {
                OptionInput option = new OptionInput();
                if (optionString.endsWith("*")) {
                    option.setContent(optionString.substring(0, optionString.length() - 1).trim());
                    option.setCorrect(true);
                } else {
                    option.setContent(optionString.trim());
                    option.setCorrect(false);
                }
                options.add(option);
            }
            question.setOptions(options);
            questions.add(question);
        }
        quiz.setQuestions(questions);

        return quiz;
    }

//    public static void main(String[] args) {
//        String questions = """
//                          [Q] Who is the first president of the USA?
//                     George Washington,Thomas Jefferson,Abraham Lincoln,John Adams*
//
//                [Q] When Georgia became independent second time?
//
//                1991*,1992,1993,1994
//
//
//
//
//                """;
//        String title = "History";
//        QuizInput quiz = parseQuiz(questions, title);
//        System.out.println(quiz);
//    }

}
