package com.catalog.controllers;

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
    public void save(@RequestBody Grade grade) {
        gradeService.save(grade);
    }
}
