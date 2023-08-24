package com.catalog.repositories;

import com.catalog.MyBatisSqlSessionFactory;
import com.catalog.models.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Override
    public List<Student> getAll() {
        try (SqlSession session = MyBatisSqlSessionFactory.openSession()) {
            List<Student> students = session.selectList("getAll");
            session.commit();
            session.close();
            return students;
        }
    }

    @Override
    public List<Student> getStudentsDetails() {
        try (SqlSession session = MyBatisSqlSessionFactory.openSession()) {
            List<Student> students = session.selectList("getStudentsDetails");
            session.commit();
            session.close();
            return students;
        }
    }

    @Override
    public Student findById(int id) {
        try (SqlSession session = MyBatisSqlSessionFactory.openSession()) {
            Student student = session.selectOne("findById", id);
            session.commit();
            session.close();
            return student;
        }
    }

    @Override
    public void save(Student student) {
        try (SqlSession session = MyBatisSqlSessionFactory.openSession()) {
            session.insert("save", student);
            session.commit();
            session.close();
        }
    }
}
