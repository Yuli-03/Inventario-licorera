package com.proyecto.licorera.service;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ProveedorDto;
import com.proyecto.licorera.exception.ServiceException;

import java.util.List;

public interface ProveedorService {

    public ProveedorDto getProveedorById (Long idProveedor) throws ServiceException;

    public List<ProveedorDto> getListProveedores() throws ServiceException;

    public void createProveedor(ProveedorDto proveedorDto) throws ServiceException;

    public void deleteProveedor(Long idProveedor) throws ServiceException;

    public void updateProveedor(ProveedorDto proveedorDto) throws ServiceException;

}
