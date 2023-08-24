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
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    @Override
    public void save(Grade grade) {
        gradeRepository.save(grade);
    }
}
