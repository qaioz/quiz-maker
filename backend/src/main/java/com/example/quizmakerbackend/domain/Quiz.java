    package com.example.quizmakerbackend.domain;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDateTime;
    import java.util.LinkedList;
    import java.util.List;


    @Getter
    @Setter
    @Entity
    public class Quiz {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long quizId;

        private String title;

        private LocalDateTime createdAt;

        @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
        private List<QuizResult> quizResults = new LinkedList<>();

        @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
        private List<Question> questions;

    }
