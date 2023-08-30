package com.catalog.controllers;

import com.catalog.apimodel.GradeDTO;
import com.catalog.mappers.GradeMapper;
import com.catalog.models.Grade;
import com.catalog.services.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public void save(@RequestBody GradeDTO gradeDTO) {
        Grade grade = GradeMapper.INSTANCE.gradeDTOtoGrade(gradeDTO);
        gradeService.save(grade);
    }

    @DeleteMapping
    public void deleteByExamAndStudentIds(@RequestBody Grade grade) {
        gradeService.deleteByExamAndStudentIds(grade.getExamId(), grade.getStudentId());
    }
}
