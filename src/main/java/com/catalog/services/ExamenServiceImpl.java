package com.catalog.services;

import com.catalog.models.Examen;
import com.catalog.repositories.ExamenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService{

    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public List<Examen> getAll() {
        return examenRepository.getAll();
    }

    @Override
    public Examen findById(int id) {
        return examenRepository.findById(id);
    }

    @Override
    public void save(Examen examen) {
        examenRepository.save(examen);
    }
}
