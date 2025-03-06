package com.proyecto.licorera.mappers;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ProveedorDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorMapper implements RowMapper<ProveedorDto> {
    @Override
    public ProveedorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProveedorDto(
                rs.getLong("id_proveedor"),
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("email")
        );
    }
}
