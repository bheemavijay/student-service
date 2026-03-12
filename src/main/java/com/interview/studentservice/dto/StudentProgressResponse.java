package com.interview.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProgressResponse {
    private Long id;
    private Long studentId;
    private Long questionId;
    private String status;
    private LocalDateTime updatedAt;
}
