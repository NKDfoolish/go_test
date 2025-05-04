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
            "SELECT s.student_id as studentId, " +
                    "math.score as mathScore, " +
                    "physics.score as physicsScore, " +
                    "chemistry.score as chemistryScore, " +
                    "(math.score + physics.score + chemistry.score) as totalScore " +
                    "FROM students s " +
                    "INNER JOIN scores math ON s.student_id = math.student_id AND math.subject = 'toan' " +
                    "INNER JOIN scores physics ON s.student_id = physics.student_id AND physics.subject = 'vat_li' " +
                    "INNER JOIN scores chemistry ON s.student_id = chemistry.student_id AND chemistry.subject = 'hoa_hoc' " +
                    "ORDER BY totalScore DESC " +
                    "LIMIT 10", nativeQuery = true)
    List<Map<String, Object>> findTop10StudentsGroupA();
}
