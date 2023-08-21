package com.catalog.services;

import com.catalog.models.Examen;

import java.util.List;

public interface ExamenService {

    public List<Examen> getAll();

    public Examen findById(int id);

    public void save(Examen examen);

//    public void deleteById(int id);
}
