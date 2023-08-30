package com.catalog.controllers;

import com.catalog.apimodel.ExamDTO;
import com.catalog.mappers.ExamMapper;
import com.catalog.models.Exam;
import com.catalog.services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public List<ExamDTO> getAll() {
        List<Exam> exams = examService.getAll();

        return exams.stream().map(ExamMapper.INSTANCE::examToExamDTO).collect(Collectors.toList());
    }

    @GetMapping("/details")
    public List<Exam> getExamsDetails() {
        return examService.getExamsDetails();
    }

    @PostMapping
    public void save(@RequestBody ExamDTO examDTO) {
        Exam exam = ExamMapper.INSTANCE.examDTOtoExam(examDTO);
        if (exam.getId() == null) {
            examService.save(exam);
        } else {
            examService.update(exam);
        }
    }

    @GetMapping("/{id}")
    public ExamDTO findById(@PathVariable int id) {
        Exam exam = examService.findById(id);

        if (exam == null) {
            throw new RuntimeException("Exam id is not found: " + id);
        }

        return ExamMapper.INSTANCE.examToExamDTO(exam);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        examService.deleteById(id);
    }
}
