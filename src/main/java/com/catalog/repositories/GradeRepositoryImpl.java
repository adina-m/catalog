package com.catalog.repositories;

import com.catalog.models.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeRepositoryImpl implements GradeRepository {

    @Override
    public List<Grade> getAll() {
        return null;
    }

    @Override
    public void save(Grade grade) {

    }
}
