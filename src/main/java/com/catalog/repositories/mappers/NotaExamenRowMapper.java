package com.catalog.repositories.mappers;

import com.catalog.models.NotaExamen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaExamenRowMapper implements RowMapper<NotaExamen> {
    @Override
    public NotaExamen mapRow(ResultSet rs, int rowNum) throws SQLException {
        NotaExamen notaExamen = new NotaExamen();
        notaExamen.setExamen_id(rs.getInt("examen_id"));
        notaExamen.setStudent_id(rs.getInt("student_id"));
        notaExamen.setNota(rs.getInt("nota"));

        return notaExamen;
    }
}
