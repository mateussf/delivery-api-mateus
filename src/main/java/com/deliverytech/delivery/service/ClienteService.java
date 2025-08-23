package com.deliverytech.delivery.service;

import com.deliverytech.delivery.dto.ClienteDTO;

public interface ClienteService {
    public Long cadastrarCliente(ClienteDTO clienteDTO);
    //public ClienteDTO findByID(Long id);
}
