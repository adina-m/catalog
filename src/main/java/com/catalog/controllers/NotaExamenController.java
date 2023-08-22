package com.catalog.controllers;

import com.catalog.models.NotaExamen;
import com.catalog.services.NotaExamenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota-examen")
public class NotaExamenController {

    private final NotaExamenService notaExamenService;

    public NotaExamenController(NotaExamenService notaExamenService) {
        this.notaExamenService = notaExamenService;
    }

    @GetMapping
    public List<NotaExamen> getAll() {
        return notaExamenService.getAll();
    }

    @PostMapping
    public void save(@RequestBody NotaExamen notaExamen) {
        notaExamenService.save(notaExamen);
    }
}
