package com.catalog.repositories;

import com.catalog.models.Student;

import java.util.List;

public interface StudentRepository {

    public List<Student> getAll();

    public Student findById(int id);

    public void save(Student student);
}
