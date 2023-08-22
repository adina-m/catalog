package com.catalog.services;

import com.catalog.models.NotaExamen;

import java.util.List;

public interface NotaExamenService {

    public List<NotaExamen> getAll();

    public void save(NotaExamen notaExamen);
}
