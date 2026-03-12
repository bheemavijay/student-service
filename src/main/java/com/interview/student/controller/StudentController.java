package com.interview.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student/test")
    public String test() {
        return "Student Service Working!";
    }
}