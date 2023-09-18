package com.catalog.controllers;

import com.catalog.apimodel.StudentDTO;
import com.catalog.apiresponse.ApiResponse;
import com.catalog.mappers.StudentMapper;
import com.catalog.models.Student;
import com.catalog.services.StudentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/student")
public class StudentController {

    private final StudentService studentService;
    private final RabbitTemplate rabbitTemplate;

    public StudentController(StudentService studentService, RabbitTemplate rabbitTemplate) {
        this.studentService = studentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public ApiResponse getAll() {
        List<Student> students = studentService.getAll();

        List<StudentDTO> studentsDTO = students.stream().map(StudentMapper.INSTANCE::studentToStudentDTO).collect(Collectors.toList());

        rabbitTemplate.convertAndSend("", "q.student-get", studentsDTO);

        return new ApiResponse("students sent");
    }

    @GetMapping("/details")
    public ApiResponse getStudentsDetails() {
        List<Student> studentsDetails = studentService.getStudentsDetails();

        rabbitTemplate.convertAndSend("", "q.student-get-details", studentsDetails);

        return new ApiResponse("students details sent");
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
