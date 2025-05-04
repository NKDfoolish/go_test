package com.go_test.scores.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private Long studentId;

    @Column(name = "no_language")
    private String noLanguage;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Score> scores;
}
