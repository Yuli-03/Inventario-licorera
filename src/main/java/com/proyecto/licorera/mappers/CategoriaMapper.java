package com.proyecto.licorera.mappers;

import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ProveedorDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<CategoriaDto> {
    @Override
    public CategoriaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CategoriaDto(
                rs.getLong("id_categoria"),
                rs.getString("nombre_categoria")
        );
    }
}
