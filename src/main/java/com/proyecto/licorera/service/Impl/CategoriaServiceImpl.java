package com.proyecto.licorera.service.Impl;

import com.proyecto.licorera.dao.CategoriaDao;
import com.proyecto.licorera.dao.ProveedorDao;
import com.proyecto.licorera.dto.CategoriaDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.exception.ServiceException;
import com.proyecto.licorera.service.CategoriaService;
import com.proyecto.licorera.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public CategoriaDto getCategoriaById(Long idCategoria) throws ServiceException {

        try {
            CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto = categoriaDao.getCategoriaById(idCategoria);
            return categoriaDto;
        }catch (Exception e){
            throw  new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<CategoriaDto> getListCategorias() throws ServiceException {

        try {

            List<CategoriaDto> listCategoriaDto = new ArrayList<>();
            listCategoriaDto = categoriaDao.getListCategorias();
            return listCategoriaDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void createCategoria(CategoriaDto categoriaDto) throws ServiceException {
        try {

            categoriaDao.createCategoria(categoriaDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void deleteCategoria(Long idCategoria) throws ServiceException {
        try {

            categoriaDao.deleteCategoria(idCategoria);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void updateCategoria(CategoriaDto categoriaDto) throws ServiceException {
        try {
            categoriaDao.updateCategoria(categoriaDto);
        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }


}
