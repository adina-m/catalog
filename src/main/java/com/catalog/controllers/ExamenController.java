package com.catalog.controllers;

import com.catalog.models.Examen;
import com.catalog.services.ExamenServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamenController {

    private final ExamenServiceImpl examenService;

    public ExamenController(ExamenServiceImpl examenService) {
        this.examenService = examenService;
    }

    @GetMapping
    public List<Examen> getAll() {
        return examenService.getAll();
    }
}
