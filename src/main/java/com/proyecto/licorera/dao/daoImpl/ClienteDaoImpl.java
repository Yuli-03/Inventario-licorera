package com.proyecto.licorera.dao.daoImpl;

import com.proyecto.licorera.dao.ClienteDao;
import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.mappers.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    @Qualifier("JdbcTemplateInventarioLicorera")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_CLIENTE_BY_ID = "SELECT * FROM clientes c WHERE id_cliente = :ID";

    private static final String SQL_GET_LIST_CLIENTES = "SELECT * FROM clientes c ";

    private static final String SQL_CREATE_CLIENTE ="INSERT INTO clientes (id_cliente, nombre_cliente, direccion, telefono, email) VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_CLIENTE = "DELETE FROM clientes a WHERE id_cliente = ?";

    private static final String SQL_UPDATE_CLIENTE = "UPDATE clientes a SET nombre_cliente = ?, direccion = ?, telefono = ?, email = ? WHERE id_cliente = ?";


    public ClienteDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ClienteDto getClienteById(Long idCliente) {
        return namedParameterJdbcTemplate.query(SQL_GET_CLIENTE_BY_ID,
                new MapSqlParameterSource("ID", idCliente), rs -> {
                    ClienteDto clienteDto = new ClienteDto();
                    if (rs.next()){
                        clienteDto.setIdCliente(rs.getLong("id_cliente"));
                        clienteDto.setNombreCliente(rs.getString("nombre_cliente"));
                        clienteDto.setDireccion(rs.getString("direccion"));
                        clienteDto.setTelefono(rs.getString("telefono"));
                        clienteDto.setEmail(rs.getString("email"));
                    }
                    return clienteDto;
                });
    }

    @Override
    public List<ClienteDto> getListClientes() {
        return namedParameterJdbcTemplate.query(SQL_GET_LIST_CLIENTES, new ClienteMapper());
    }

    @Override
    public void createCliente(ClienteDto clienteDto) {
        jdbcTemplate.update(SQL_CREATE_CLIENTE, clienteDto.getIdCliente(), clienteDto.getNombreCliente(),
                            clienteDto.getDireccion(), clienteDto.getTelefono(), clienteDto.getEmail());
    }

    @Override
    public void deleteCliente(Long idCliente) {
        jdbcTemplate.update(SQL_DELETE_CLIENTE, idCliente);
    }

    @Override
    public void updateCliente(ClienteDto clienteDto) {
        jdbcTemplate.update(SQL_UPDATE_CLIENTE, clienteDto.getNombreCliente(), clienteDto.getDireccion(), clienteDto.getTelefono(), clienteDto.getEmail(), clienteDto.getIdCliente());
    }

}
