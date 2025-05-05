package com.go_test.scores.controller;

import com.go_test.scores.entity.Student;
import com.go_test.scores.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/student/{registrationNumber}")
    public ResponseEntity<Student> getStudentByRegistrationNumber(@PathVariable Long registrationNumber) {
        return ResponseEntity.ok(scoreService.getStudentByRegistrationNumber(registrationNumber));
    }

    @GetMapping("/statistics/{subject}")
    public ResponseEntity<Map<String, Object>> getScoreStatisticsBySubject(@PathVariable String subject) {
        return ResponseEntity.ok(scoreService.getScoreStatisticsBySubject(subject));
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<Map<String, Object>>> getAllSubjectsScoreStatistics() {
        return ResponseEntity.ok(scoreService.getAllSubjectsScoreStatistics());
    }

    @GetMapping("/top10-group-a")
    public ResponseEntity<List<Map<String, Object>>> getTop10GroupA() {
        return ResponseEntity.ok(scoreService.getTop10StudentsGroupA());
    }
}