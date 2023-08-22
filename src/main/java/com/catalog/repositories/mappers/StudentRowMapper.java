package com.catalog.repositories.mappers;

import com.catalog.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudent_id(rs.getInt("student_id"));
        student.setNume(rs.getString("nume"));
        student.setGrupa(rs.getString("grupa"));
        student.setAn_studii(rs.getInt("an_studii"));

        return student;
    }
}
