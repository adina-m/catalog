package com.catalog.services;

import com.catalog.models.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAll();

    public Student findById(int id);

    public void save(Student student);

//    public void deleteById(int id);
}
