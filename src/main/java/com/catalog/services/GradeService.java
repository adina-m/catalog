package com.catalog.services;

import com.catalog.models.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> getAll();

    public void save(Grade grade);
}
