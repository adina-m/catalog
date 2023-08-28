package com.catalog.services;

import com.catalog.models.Grade;
import com.catalog.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void save(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteByExamAndStudentIds(int examId, int studentId) {
        gradeRepository.deleteByExamAndStudentIds(examId, studentId);
    }
}
