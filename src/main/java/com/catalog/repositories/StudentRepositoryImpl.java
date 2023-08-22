package com.catalog.repositories;

import com.catalog.models.Student;
import com.catalog.repositories.mappers.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final JdbcTemplate jdbc;

    public StudentRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> getAll() {
        String sql = "select * from student";

        return jdbc.query(sql, new StudentRowMapper());
    }

    @Override
    public Student findById(int id) {
        String sql = "select * from student where student_id = ?";

        return jdbc.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student(nume, grupa, an_studii) values(?,?,?)";

        jdbc.update(sql, student.getNume(), student.getGrupa(), student.getAn_studii());
    }
}
