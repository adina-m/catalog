package com.catalog.controllers;

import com.catalog.apimodel.StudentDTO;
import com.catalog.mappers.StudentMapper;
import com.catalog.models.Student;
import com.catalog.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        List<Student> students = studentService.getAll();

        return students.stream().map(StudentMapper.INSTANCE::studentToStudentDTO).collect(Collectors.toList());

    }

    @GetMapping("/details")
    public List<Student> getStudentsDetails() {
        return studentService.getStudentsDetails();
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new RuntimeException("Student id not found: " + id);
        }

        return StudentMapper.INSTANCE.studentToStudentDTO(student);
    }

    @PostMapping
    public void save(@RequestBody StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE.studentDTOtoStudent(studentDTO);
        if (student.getId() == null) {
            studentService.save(student);
        } else {
            studentService.update(student);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }
}
