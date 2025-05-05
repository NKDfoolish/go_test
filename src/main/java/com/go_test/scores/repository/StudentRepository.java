package com.go_test.scores.repository;

import com.go_test.scores.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentId(Long studentId);

    @Query(value =
            "SELECT " +
            "    t.student_id AS studentId," +
            "    t.mathScore," +
            "    t.physicsScore," +
            "    t.chemistryScore," +
            "    t.totalScore " +
            "FROM (" +
            "    SELECT " +
            "        sc.student_id," +
            "        MAX(CASE WHEN sc.subject = 'toan' THEN sc.score END) AS mathScore," +
            "        MAX(CASE WHEN sc.subject = 'vat_li' THEN sc.score END) AS physicsScore," +
            "        MAX(CASE WHEN sc.subject = 'hoa_hoc' THEN sc.score END) AS chemistryScore," +
            "        SUM(sc.score) AS totalScore " +
            "    FROM Scores sc " +
            "    WHERE sc.subject IN ('toan', 'vat_li', 'hoa_hoc') " +
            "    GROUP BY sc.student_id " +
            "    HAVING COUNT(DISTINCT sc.subject) = 3 " +
            ") t " +
            "ORDER BY t.totalScore DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Map<String, Object>> findTop10StudentsGroupA();
}
