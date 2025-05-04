package com.go_test.scores.service;

import com.go_test.scores.entity.*;
import com.go_test.scores.repository.ScoreRepository;
import com.go_test.scores.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    // Subject instances to use throughout the service
    private final Subject mathSubject = new MathSubject();
    private final Subject physicsSubject = new PhysicsSubject();
    private final Subject chemistrySubject = new ChemistrySubject();

    public Student getStudentByRegistrationNumber(Long registrationNumber) {
        return studentRepository.findByStudentId(registrationNumber)
                .orElseThrow(() -> new RuntimeException("Student not found with registration number: " + registrationNumber));
    }

    public Map<String, Long> getScoreStatisticsBySubject(String subjectName) {
        return scoreRepository.getScoreStatistics(subjectName);
    }

    public List<Map<String, Object>> getTop10StudentsGroupA() {
        return studentRepository.findTop10StudentsGroupA();
    }
}