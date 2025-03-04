package com.proyecto.licorera.mappers;

import com.proyecto.licorera.dto.ClienteDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<ClienteDto> {
    @Override
    public ClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClienteDto(
                rs.getLong("id_cliente"),
                rs.getString("nombre_cliente"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("email")
        );
    }
}
