package com.catalog.repositories;

import com.catalog.models.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamRepository {

    public List<Exam> getAll();

    public List<Exam> getExamsDetails();

    public Exam findById(int id);

    public void save(Exam exam);

    public void update(Exam exam);

    public void deleteById(int id);
}
