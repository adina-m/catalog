package com.catalog.repositories.mappers;

import com.catalog.models.Examen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamenRowMapper implements RowMapper<Examen> {
    @Override
    public Examen mapRow(ResultSet rs, int rowNum) throws SQLException {
        Examen examen = new Examen();
        examen.setExamen_id(rs.getInt("examen_id"));
        examen.setGrupa(rs.getString("grupa"));
        examen.setMaterie(rs.getString("materie"));
        examen.setNume_profesor(rs.getString("nume_profesor"));
        examen.setData_examen(rs.getTimestamp("data_examen"));
        examen.setSala(rs.getString("sala"));

        return examen;
    }
}
