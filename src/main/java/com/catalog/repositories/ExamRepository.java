package com.catalog.repositories;

import com.catalog.models.Exam;

import java.util.List;

public interface ExamRepository {

    public List<Exam> getAll();

    public Exam findById(int id);

    public void save(Exam exam);
}
