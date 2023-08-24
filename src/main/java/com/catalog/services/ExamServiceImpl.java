package com.catalog.services;

import com.catalog.models.Exam;
import com.catalog.repositories.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public List<Exam> getAll() {
        return examRepository.getAll();
    }

    @Override
    public Exam findById(int id) {
        return examRepository.findById(id);
    }

    @Override
    public void save(Exam exam) {
        examRepository.save(exam);
    }
}
