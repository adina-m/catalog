package com.catalog.controllers;

import com.catalog.models.Exam;
import com.catalog.services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<Exam> getAll() {
        return examService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Exam exam) {
        examService.save(exam);
    }

    @GetMapping("/{id}")
    public Exam findById(@PathVariable int id) {
        return examService.findById(id);
    }
}
