package com.catalog.repositories;

import com.catalog.models.NotaExamen;

import java.util.List;

public interface NotaExamenRepository {

    public List<NotaExamen> getAll();

    public void save(NotaExamen notaExamen);
}
