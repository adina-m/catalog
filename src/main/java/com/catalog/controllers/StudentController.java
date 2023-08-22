package com.catalog.controllers;

import com.catalog.models.Student;
import com.catalog.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new RuntimeException("Student id not found: " + id);
        }

        return student;
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }
}
