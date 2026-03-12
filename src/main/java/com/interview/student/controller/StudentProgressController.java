package com.interview.student.controller;

import com.interview.student.dto.StudentProgressRequest;
import com.interview.student.dto.StudentProgressResponse;
import com.interview.student.service.StudentProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentProgressController {

    @Autowired
    private StudentProgressService studentProgressService;

    @PostMapping("/progress")
    public ResponseEntity<StudentProgressResponse> saveProgress(@RequestBody StudentProgressRequest request) {
        StudentProgressResponse savedProgress = studentProgressService.saveProgress(request);
        return ResponseEntity.ok(savedProgress);
    }

    @GetMapping("/{studentId}/progress")
    public ResponseEntity<List<StudentProgressResponse>> getProgress(@PathVariable Long studentId) {
        List<StudentProgressResponse> progressList = studentProgressService.getProgressByStudentId(studentId);
        return ResponseEntity.ok(progressList);
    }

    @GetMapping("/{studentId}/solved")
    public ResponseEntity<List<StudentProgressResponse>> getSolvedQuestions(@PathVariable Long studentId) {
        List<StudentProgressResponse> solvedList = studentProgressService.getSolvedQuestionsByStudentId(studentId);
        return ResponseEntity.ok(solvedList);
    }
}
