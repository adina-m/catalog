package com.catalog.repositories;

import com.catalog.models.Examen;
import com.catalog.repositories.mappers.ExamenRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamenRepositoryImpl implements ExamenRepository{

    private final JdbcTemplate jdbc;

    public ExamenRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Examen> getAll() {
        String sql = "select * from examen";

        return jdbc.query(sql, new ExamenRowMapper());
    }

    @Override
    public Examen findById(int id) {
        String sql = "select * from examen where examen_id = ?";

        return jdbc.queryForObject(sql, new ExamenRowMapper(), id);
    }

    @Override
    public void save(Examen examen) {
        String sql = "insert into examen(grupa, materie, nume_profesor, data_examen, sala) values (?,?,?,?,?)";

        jdbc.update(sql, examen.getGrupa(), examen.getMaterie(), examen.getNume_profesor(), examen.getData_examen(), examen.getSala());
    }
}
