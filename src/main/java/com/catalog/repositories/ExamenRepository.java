package com.catalog.repositories;

import com.catalog.models.Examen;

import java.util.List;

public interface ExamenRepository {

    public List<Examen> getAll();

    public Examen findById(int id);

    public void save(Examen examen);
}
