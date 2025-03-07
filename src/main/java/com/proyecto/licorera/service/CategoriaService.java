package com.proyecto.licorera.service;

import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.exception.ServiceException;

import java.util.List;

public interface CategoriaService {

    public CategoriaDto getCategoriaById (Long idCategoria) throws ServiceException;

    public List<CategoriaDto> getListCategorias() throws ServiceException;

    public void createCategoria(CategoriaDto categoriaDto) throws ServiceException;

    public void deleteCategoria(Long idCategoria) throws ServiceException;

    public void updateCategoria(CategoriaDto categoriaDto) throws ServiceException;

}
