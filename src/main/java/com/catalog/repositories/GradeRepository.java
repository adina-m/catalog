package com.catalog.repositories;

import com.catalog.models.Grade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeRepository {

    public void save(Grade grade);

    public void deleteByExamAndStudentIds(int examId, int studentId);

    public void deleteByExamId(int id);
    public void deleteByStudentId(int id);
}
