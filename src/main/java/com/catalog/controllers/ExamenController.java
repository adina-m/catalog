package com.catalog.controllers;

import com.catalog.models.Examen;
import com.catalog.services.ExamenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @GetMapping
    public List<Examen> getAll() {
        return examenService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Examen examen) {
        examenService.save(examen);
    }

    @GetMapping("/{id}")
    public Examen findById(@PathVariable int id) {
        return examenService.findById(id);
    }
}
