package com.proyecto.licorera.service.Impl;

import com.proyecto.licorera.dao.ClienteDao;
import com.proyecto.licorera.dto.ClienteDto;
import com.proyecto.licorera.exception.ServiceException;
import com.proyecto.licorera.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public ClienteDto getClienteById(Long idCliente) throws ServiceException {

        try {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto = clienteDao.getClienteById(idCliente);
            return clienteDto;
        }catch (Exception e){
            throw  new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<ClienteDto> getListClientes() throws ServiceException {

        try {

            List<ClienteDto> listClienteDto = new ArrayList<>();
            listClienteDto = clienteDao.getListClientes();
            return listClienteDto;

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void createCliente(ClienteDto clienteDto) throws ServiceException {
        try {

            clienteDao.createCliente(clienteDto);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void deleteCliente(Long idCliente) throws ServiceException {
        try {

            clienteDao.deleteCliente(idCliente);

        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void updateCliente(ClienteDto clienteDto) throws ServiceException {
        try {
            clienteDao.updateCliente(clienteDto);
        } catch (Exception e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }


}
