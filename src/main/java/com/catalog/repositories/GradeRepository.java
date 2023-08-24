package com.catalog.repositories;

import com.catalog.models.Grade;

import java.util.List;

public interface GradeRepository {

    public List<Grade> getAll();

    public void save(Grade grade);
}
