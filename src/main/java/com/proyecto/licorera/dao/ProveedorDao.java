package com.proyecto.licorera.dao;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.dto.ProveedorDto;

import java.util.List;

public interface ProveedorDao {

    public ProveedorDto getProveedorById (Long idProveedor);

    public List<ProveedorDto> getListProveedores();

    public void createProveedor(ProveedorDto proveedorDto);

    public void deleteProveedor(Long idProveedor);

    public void updateProveedor(ProveedorDto proveedorDto);


}
