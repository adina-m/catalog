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
    public List<Exam> getExamsDetails() {
        return examRepository.getExamsDetails();
    }

    @Override
    public Exam findById(int id) {
        return examRepository.findById(id);
    }

    @Override
    public void save(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void update(Exam exam) {
        examRepository.update(exam);
    }

    @Override
    public void deleteById(int id) {
        examRepository.deleteById(id);
    }
}
