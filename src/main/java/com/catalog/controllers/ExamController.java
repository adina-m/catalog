package com.catalog.controllers;

import com.catalog.models.Exam;
import com.catalog.services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<Exam> getAll() {
        return examService.getAll();
    }

    @GetMapping("/details")
    public List<Exam> getExamsDetails() {
        return examService.getExamsDetails();
    }

    @PostMapping
    public void save(@RequestBody Exam exam) {
        if (exam.getId() == null) {
            examService.save(exam);
        } else {
            examService.update(exam);
        }
    }

    @GetMapping("/{id}")
    public Exam findById(@PathVariable int id) {
        return examService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        examService.deleteById(id);
    }
}
