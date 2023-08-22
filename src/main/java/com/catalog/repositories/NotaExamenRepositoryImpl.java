package com.catalog.repositories;

import com.catalog.models.NotaExamen;
import com.catalog.repositories.mappers.NotaExamenRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaExamenRepositoryImpl implements NotaExamenRepository{

    private final JdbcTemplate jdbc;

    public NotaExamenRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<NotaExamen> getAll() {
        String sql = "select * from nota_examen";

        return jdbc.query(sql, new NotaExamenRowMapper());
    }

    @Override
    public void save(NotaExamen notaExamen) {
        String sql = "insert into nota_examen(examen_id, student_id, nota) values (?,?,?)";

        jdbc.update(sql, notaExamen.getExamen_id(), notaExamen.getStudent_id(), notaExamen.getNota());
    }
}
