package com.go_test.scores.repository;

import com.go_test.scores.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT " +
            "sc.subject as subject, " +
            "SUM(CASE WHEN sc.score >= 8 THEN 1 ELSE 0 END) as highScore, " +
            "SUM(CASE WHEN sc.score >= 6 AND sc.score < 8 THEN 1 ELSE 0 END) as goodScore, " +
            "SUM(CASE WHEN sc.score >= 4 AND sc.score < 6 THEN 1 ELSE 0 END) as averageScore, " +
            "SUM(CASE WHEN sc.score < 4 THEN 1 ELSE 0 END) as lowScore " +
            "FROM scores sc " +
            "JOIN students s ON sc.student_id = s.student_id " +
            "GROUP BY sc.subject " +
            "ORDER BY sc.subject", nativeQuery = true)
    List<Map<String, Object>> getAllSubjectsScoreStatistics();

    @Query(value = "SELECT " +
            "sc.subject as subject, " +
            "SUM(CASE WHEN sc.score >= 8 THEN 1 ELSE 0 END) as highScore, " +
            "SUM(CASE WHEN sc.score >= 6 AND sc.score < 8 THEN 1 ELSE 0 END) as goodScore, " +
            "SUM(CASE WHEN sc.score >= 4 AND sc.score < 6 THEN 1 ELSE 0 END) as averageScore, " +
            "SUM(CASE WHEN sc.score < 4 THEN 1 ELSE 0 END) as lowScore " +
            "FROM scores sc " +
            "JOIN students s ON sc.student_id = s.student_id " +
            "WHERE sc.subject = :subject " +
            "GROUP BY sc.subject", nativeQuery = true)
    Map<String, Object> getScoreStatisticsBySubject(@Param("subject") String subject);
}
