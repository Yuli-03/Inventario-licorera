package com.proyecto.licorera.dao;

import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ProveedorDto;

import java.util.List;

public interface CategoriaDao {

    public CategoriaDto getCategoriaById (Long idCategoria);

    public List<CategoriaDto> getListCategorias();

    public void createCategoria(CategoriaDto categoriaDto);

    public void deleteCategoria(Long idCategoria);

    public void updateCategoria(CategoriaDto categoriaDto);

}
