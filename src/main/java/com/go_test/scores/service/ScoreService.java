package com.go_test.scores.service;

import com.go_test.scores.entity.*;
import com.go_test.scores.repository.ScoreRepository;
import com.go_test.scores.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public Student getStudentByRegistrationNumber(Long registrationNumber) {
        return studentRepository.findByStudentId(registrationNumber)
                .orElseThrow(() -> new RuntimeException("Student not found with registration number: " + registrationNumber));
    }

    public List<Map<String, Object>> getAllSubjectsScoreStatistics() {
        return scoreRepository.getAllSubjectsScoreStatistics();
    }

    public Map<String, Object> getScoreStatisticsBySubject(String subject) {
        return scoreRepository.getScoreStatisticsBySubject(subject);
    }

    public List<Map<String, Object>> getTop10StudentsGroupA() {
        return studentRepository.findTop10StudentsGroupA();
    }
}