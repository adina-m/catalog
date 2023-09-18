package com.catalog.services.rabbitmq.consumer;

import com.catalog.apimodel.StudentDTO;
import com.catalog.mappers.StudentMapper;
import com.catalog.models.Student;
import com.catalog.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentListener {
    private final StudentService studentService;

    public StudentListener(StudentService studentService) {
        this.studentService = studentService;
    }

    @RabbitListener(queues = {"q.student-creation"})
    public void onStudentCreate(StudentDTO studentDTO) {
        log.info("student received: {}", studentDTO);
        Student student = StudentMapper.INSTANCE.studentDTOtoStudent(studentDTO);
        studentService.save(student);
    }

    @RabbitListener(queues = {"q.student-update"})
    public void onStudentUpdate(StudentDTO studentDTO) {
        log.info("student received: {}", studentDTO);
        Student student = StudentMapper.INSTANCE.studentDTOtoStudent(studentDTO);
        studentService.update(student);
    }
}
