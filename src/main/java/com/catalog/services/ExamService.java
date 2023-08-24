package com.catalog.services;

import com.catalog.models.Exam;

import java.util.List;

public interface ExamService {

    public List<Exam> getAll();

    public Exam findById(int id);

    public void save(Exam exam);

//    public void deleteById(int id);
}
