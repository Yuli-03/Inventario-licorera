package com.proyecto.licorera.dao.daoImpl;

import com.proyecto.licorera.dao.ClienteDao;
import com.proyecto.licorera.dao.ProveedorDao;
import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.mappers.ClienteMapper;
import com.proyecto.licorera.mappers.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProveedorDaoImpl implements ProveedorDao {

    @Autowired
    @Qualifier("JdbcTemplateInventarioLicorera")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_PROVEEDOR_BY_ID = "SELECT * FROM proveedores p WHERE id_proveedor = :ID";

    private static final String SQL_GET_LIST_PROVEEDORES = "SELECT * FROM proveedores p ";

    private static final String SQL_CREATE_PROVEEDOR ="INSERT INTO proveedores (id_proveedor, nombre, direccion, telefono, email) VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_PROVEEDOR = "DELETE FROM proveedores a WHERE id_proveedor = ?";

    private static final String SQL_UPDATE_PROVEEDOR = "UPDATE proveedores a SET nombre = ?, direccion = ?, telefono = ?, email = ? WHERE id_proveedor = ?";


    public ProveedorDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProveedorDto getProveedorById(Long idProveedor) {
        return namedParameterJdbcTemplate.query(SQL_GET_PROVEEDOR_BY_ID,
                new MapSqlParameterSource("ID", idProveedor), rs -> {
                    ProveedorDto proveedorDto = new ProveedorDto();
                    if (rs.next()){
                        proveedorDto.setIdProveedor(rs.getLong("id_proveedor"));
                        proveedorDto.setNombre(rs.getString("nombre"));
                        proveedorDto.setDireccion(rs.getString("direccion"));
                        proveedorDto.setTelefono(rs.getString("telefono"));
                        proveedorDto.setEmail(rs.getString("email"));
                    }
                    return proveedorDto;
                });
    }

    @Override
    public List<ProveedorDto> getListProveedores() {
        return namedParameterJdbcTemplate.query(SQL_GET_LIST_PROVEEDORES, new ProveedorMapper());
    }

    @Override
    public void createProveedor(ProveedorDto proveedorDto) {
        jdbcTemplate.update(SQL_CREATE_PROVEEDOR, proveedorDto.getIdProveedor(), proveedorDto.getNombre(),
                            proveedorDto.getDireccion(), proveedorDto.getTelefono(), proveedorDto.getEmail());
    }

    @Override
    public void deleteProveedor(Long idProveedor) {
        jdbcTemplate.update(SQL_DELETE_PROVEEDOR, idProveedor);
    }

    @Override
    public void updateProveedor(ProveedorDto proveedorDto) {
        jdbcTemplate.update(SQL_UPDATE_PROVEEDOR, proveedorDto.getNombre(), proveedorDto.getDireccion(), proveedorDto.getTelefono(), proveedorDto.getEmail(), proveedorDto.getIdProveedor());
    }

}
