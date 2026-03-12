package com.interview.student.repository;

import com.interview.student.entity.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
    List<StudentProgress> findByStudentId(Long studentId);
    List<StudentProgress> findByStudentIdAndStatus(Long studentId, String status);
    Optional<StudentProgress> findByStudentIdAndQuestionId(Long studentId, Long questionId);
}
