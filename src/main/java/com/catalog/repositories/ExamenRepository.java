package com.catalog.repositories;

import com.catalog.models.Examen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamenRepository {

    private final JdbcTemplate jdbc;

    public ExamenRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Examen> getAll() {
        String sql = "select * from examen";

        RowMapper<Examen> examenRowMapper = (r, i) -> {
            Examen rowObject = new Examen();
            rowObject.setExamen_id(r.getInt("examen_id"));
            rowObject.setGrupa(r.getString("grupa"));
            rowObject.setMaterie(r.getString("materie"));
            rowObject.setNume_profesor(r.getString("nume_profesor"));
            rowObject.setData_examen(r.getDate("data_examen"));
            rowObject.setSala(r.getString("sala"));
            return rowObject;
        };

        return jdbc.query(sql, examenRowMapper);
    }
}
