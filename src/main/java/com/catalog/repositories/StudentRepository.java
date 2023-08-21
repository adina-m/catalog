package com.catalog.repositories;

import com.catalog.models.Examen;
import com.catalog.models.NotaExamen;
import com.catalog.models.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> getAll() {
        String sql = "select s.*, ne.*, e.* from student as s " +
                        "left join nota_examen ne on s.student_id = ne.student_id " +
                        "left join examen e on ne.examen_id = e.examen_id";

//        RowMapper<Student> studentRowMapper = (r, i) -> {
//            Student rowObject = new Student();
//            rowObject.setStudent_id(r.getInt("student_id"));
//            rowObject.setNume(r.getString("nume"));
//            rowObject.setGrupa(r.getString("grupa"));
//            rowObject.setAn_studii(r.getInt("an_studii"));
//
//            return rowObject;
//        };
//
//        return jdbc.query(sql, studentRowMapper);

        return jdbc.query(sql, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> students = new ArrayList<Student>();
                while (rs.next()) {
                    Student student = new Student();
                    student.setStudent_id(rs.getInt("student_id"));
                    student.setNume(rs.getString("nume"));
                    student.setGrupa(rs.getString("grupa"));
                    student.setAn_studii(rs.getInt("an_studii"));

                    List<Examen> examenList = student.getListaExamene();
                    if (examenList == null) {
                        examenList = new ArrayList<Examen>();
                    }
                    Examen examen = new Examen();
                    examen.setExamen_id(rs.getInt("examen_id"));
                    examen.setGrupa(rs.getString("grupa"));
                    examen.setMaterie(rs.getString("materie"));
                    examen.setNume_profesor(rs.getString("nume_profesor"));
                    examen.setSala(rs.getString("sala"));
                    examen.setData_examen(rs.getTimestamp("data_examen"));

                    List<NotaExamen> gradesList = examen.getNotaExamen();
                    if (gradesList == null) {
                        gradesList = new ArrayList<NotaExamen>();
                    }
                    NotaExamen notaExamen = new NotaExamen();
                    notaExamen.setExamen_id(rs.getInt("examen_id"));
                    notaExamen.setStudent_id(rs.getInt("student_id"));
                    notaExamen.setNota(rs.getInt("nota"));
                    gradesList.add(notaExamen);
                    examen.setNotaExamen(gradesList);

                    examenList.add(examen);
                    student.setListaExamene(examenList);
                    students.add(student);
                }
                return students;
            }
        });
    }
}
