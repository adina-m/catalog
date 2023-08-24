package com.catalog.repositories;

import com.catalog.models.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamRepositoryImpl implements ExamRepository {


    @Override
    public List<Exam> getAll() {
        return null;
    }

    @Override
    public Exam findById(int id) {
        return null;
    }

    @Override
    public void save(Exam exam) {

    }
}
