package com.deliverytech.delivery.service;

import java.util.List;

import com.deliverytech.delivery.dto.ClienteDTO;

public interface IClienteService {
    public Long cadastrarCliente(ClienteDTO clienteDTO);
    public ClienteDTO alterarCliente(Long id, ClienteDTO cliente);
}
