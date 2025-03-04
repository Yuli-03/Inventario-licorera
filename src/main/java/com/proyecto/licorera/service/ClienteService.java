package com.proyecto.licorera.service;

import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.exception.ServiceException;

import java.util.List;

public interface ClienteService {

    public ClienteDto getClienteById (Long idCliente) throws ServiceException;

    public List<ClienteDto> getListClientes() throws ServiceException;

    public void createCliente(ClienteDto clienteDto) throws ServiceException;

    public void deleteCliente(Long idCliente) throws ServiceException;

    public void updateCliente(ClienteDto clienteDto) throws ServiceException;

}
