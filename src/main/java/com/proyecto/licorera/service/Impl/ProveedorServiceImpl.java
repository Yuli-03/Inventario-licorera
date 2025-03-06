package com.proyecto.licorera.service.Impl;

import com.proyecto.licorera.dao.ClienteDao;
import com.proyecto.licorera.dao.ProveedorDao;
import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.exception.ServiceException;
import com.proyecto.licorera.service.ClienteService;
import com.proyecto.licorera.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public ProveedorDto getProveedorById(Long idProveedor) throws ServiceException {

        try {
            ProveedorDto proveedorDto = new ProveedorDto();
            proveedorDto = proveedorDao.getProveedorById(idProveedor);
            return proveedorDto;
        }catch (Exception e){
            throw  new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<ProveedorDto> getListProveedores() throws ServiceException {

        try {

            List<ProveedorDto> listProveedorDto = new ArrayList<>();
            listProveedorDto = proveedorDao.getListProveedores();
            return listProveedorDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void createProveedor(ProveedorDto proveedorDto) throws ServiceException {
        try {

            proveedorDao.createProveedor(proveedorDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void deleteProveedor(Long idProveedor) throws ServiceException {
        try {

            proveedorDao.deleteProveedor(idProveedor);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void updateProveedor(ProveedorDto proveedorDto) throws ServiceException {
        try {
            proveedorDao.updateProveedor(proveedorDto);
        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }


}
