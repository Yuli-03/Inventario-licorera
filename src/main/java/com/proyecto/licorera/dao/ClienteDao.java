package com.proyecto.licorera.dao;

import com.proyecto.licorera.dto.ClienteDto;

import java.util.List;

public interface ClienteDao {

    public ClienteDto getClienteById (Long idCliente);

    public List<ClienteDto> getListClientes();

    public void createCliente(ClienteDto clienteDto);

    public void deleteCliente(Long idCliente);

    public void updateCliente(ClienteDto clienteDto);


}
