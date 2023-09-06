package com.catalog.controllers;

import com.catalog.apimodel.StudentDTO;
import com.catalog.apiresponse.ApiResponse;
import com.catalog.mappers.StudentMapper;
import com.catalog.models.Student;
import com.catalog.services.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/student",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;
    private final RabbitTemplate rabbitTemplate;

    public StudentController(StudentService studentService, RabbitTemplate rabbitTemplate) {
        this.studentService = studentService;
        this.rabbitTemplate = rabbitTemplate;
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
    public ApiResponse save(@RequestBody StudentDTO studentDTO) {
        rabbitTemplate.convertAndSend("", "q.student-creation", studentDTO);
        return new ApiResponse("saved");
    }

    @PutMapping
    public ApiResponse update(@RequestBody StudentDTO studentDTO) {
        rabbitTemplate.convertAndSend("", "q.student-update", studentDTO);
        return new ApiResponse("updated");
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }
}
