package com.interview.student.service;

import com.interview.student.dto.StudentProgressRequest;
import com.interview.student.dto.StudentProgressResponse;
import com.interview.student.entity.StudentProgress;
import com.interview.student.repository.StudentProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentProgressService {

    @Autowired
    private StudentProgressRepository studentProgressRepository;

    public StudentProgressResponse saveProgress(StudentProgressRequest request) {
        Optional<StudentProgress> existingProgress = studentProgressRepository.findByStudentIdAndQuestionId(request.getStudentId(), request.getQuestionId());
        StudentProgress progress;
        if (existingProgress.isPresent()) {
            progress = existingProgress.get();
            progress.setStatus(request.getStatus());
        } else {
            progress = new StudentProgress();
            progress.setStudentId(request.getStudentId());
            progress.setQuestionId(request.getQuestionId());
            progress.setStatus(request.getStatus());
        }
        StudentProgress savedProgress = studentProgressRepository.save(progress);
        return mapToResponse(savedProgress);
    }

    public List<StudentProgressResponse> getProgressByStudentId(Long studentId) {
        List<StudentProgress> progressList = studentProgressRepository.findByStudentId(studentId);
        return progressList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<StudentProgressResponse> getSolvedQuestionsByStudentId(Long studentId) {
        List<StudentProgress> solvedList = studentProgressRepository.findByStudentIdAndStatus(studentId, "SOLVED");
        return solvedList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private StudentProgressResponse mapToResponse(StudentProgress progress) {
        return StudentProgressResponse.builder()
                .id(progress.getId())
                .studentId(progress.getStudentId())
                .questionId(progress.getQuestionId())
                .status(progress.getStatus())
                .updatedAt(progress.getUpdatedAt())
                .build();
    }
}
