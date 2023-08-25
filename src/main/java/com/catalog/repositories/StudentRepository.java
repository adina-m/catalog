package com.catalog.repositories;

import com.catalog.models.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {

    public List<Student> getAll();

    public List<Student> getStudentsDetails();

    public Student findById(int id);

    public void save(Student student);

    public void update(Student student);

    public void deleteById(int id);
}
