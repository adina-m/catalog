package com.catalog.services;

import com.catalog.models.NotaExamen;
import com.catalog.repositories.NotaExamenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaExamenServiceImpl implements NotaExamenService{

    private final NotaExamenRepository notaExamenRepository;

    public NotaExamenServiceImpl(NotaExamenRepository notaExamenRepository) {
        this.notaExamenRepository = notaExamenRepository;
    }

    @Override
    public List<NotaExamen> getAll() {
        return notaExamenRepository.getAll();
    }

    @Override
    public void save(NotaExamen notaExamen) {
        notaExamenRepository.save(notaExamen);
    }
}
