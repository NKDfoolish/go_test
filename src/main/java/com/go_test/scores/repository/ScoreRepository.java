package com.go_test.scores.repository;

import com.go_test.scores.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT " +
            "SUM(CASE WHEN score >= 8 THEN 1 ELSE 0 END) as excellent, " +
            "SUM(CASE WHEN score >= 6 AND score < 8 THEN 1 ELSE 0 END) as good, " +
            "SUM(CASE WHEN score >= 4 AND score < 6 THEN 1 ELSE 0 END) as average, " +
            "SUM(CASE WHEN score < 4 THEN 1 ELSE 0 END) as belowAverage " +
            "FROM scores WHERE subject = :subject", nativeQuery = true)
    Map<String, Long> getScoreStatistics(@Param("subject") String subject);
}
