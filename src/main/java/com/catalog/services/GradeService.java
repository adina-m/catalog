package com.catalog.services;

import com.catalog.models.Grade;

import java.util.List;

public interface GradeService {

    public void save(Grade grade);

    public void deleteByExamAndStudentIds(int examId, int studentId);
}
