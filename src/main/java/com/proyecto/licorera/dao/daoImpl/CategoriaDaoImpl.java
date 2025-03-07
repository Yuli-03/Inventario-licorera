package com.proyecto.licorera.dao.daoImpl;

import com.proyecto.licorera.dao.CategoriaDao;
import com.proyecto.licorera.dao.ProveedorDao;
import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.mappers.CategoriaMapper;
import com.proyecto.licorera.mappers.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CategoriaDaoImpl implements CategoriaDao {

    @Autowired
    @Qualifier("JdbcTemplateInventarioLicorera")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_CATEGORIA_BY_ID = "SELECT * FROM categorias c WHERE id_categoria = :ID";

    private static final String SQL_GET_LIST_CATEGORIAS = "SELECT * FROM categorias c ";

    private static final String SQL_CREATE_CATEGORIA ="INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (?,?)";

    private static final String SQL_DELETE_CATEGORIA = "DELETE FROM categorias c WHERE id_categoria = ?";

    private static final String SQL_UPDATE_CATEGORIA = "UPDATE categorias c SET nombre_categoria = ? WHERE id_categoria = ?";


    public CategoriaDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CategoriaDto getCategoriaById(Long idCategoria) {
        return namedParameterJdbcTemplate.query(SQL_GET_CATEGORIA_BY_ID,
                new MapSqlParameterSource("ID", idCategoria), rs -> {
                    CategoriaDto categoriaDto = new CategoriaDto();
                    if (rs.next()){
                        categoriaDto.setIdCategoria(rs.getLong("id_categoria"));
                        categoriaDto.setNombreCategoria(rs.getString("nombre_categoria"));
                    }
                    return categoriaDto;
                });
    }

    @Override
    public List<CategoriaDto> getListCategorias() {
        return namedParameterJdbcTemplate.query(SQL_GET_LIST_CATEGORIAS, new CategoriaMapper());
    }

    @Override
    public void createCategoria(CategoriaDto categoriaDto) {
        jdbcTemplate.update(SQL_CREATE_CATEGORIA, categoriaDto.getIdCategoria(), categoriaDto.getNombreCategoria());
    }

    @Override
    public void deleteCategoria(Long idCategoria) {
        jdbcTemplate.update(SQL_DELETE_CATEGORIA, idCategoria);
    }

    @Override
    public void updateCategoria(CategoriaDto categoriaDto) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORIA, categoriaDto.getNombreCategoria(), categoriaDto.getIdCategoria());
    }

}
