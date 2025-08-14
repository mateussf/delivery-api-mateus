package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ClienteDTO;
import com.deliverytech.delivery_api.model.ClienteModel;
import com.deliverytech.delivery_api.repository.IClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository repository;

    public ClienteService(IClienteRepository restaurantRespository) {
        this.repository = restaurantRespository;
    }

    public ClienteService() {
        super();
    }

    public List<ClienteDTO> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDTO).collect(Collectors.toList());
    }

    private ClienteDTO ConvertEntityToDTO(ClienteModel entity)
    {
        ClienteDTO dto = new ClienteDTO();
        dto.setNome(entity.getNome());
        dto.setEmail((entity.getEmail()));
        dto.setTelefone(entity.getTelefone());
        dto.setEndereco(entity.getEndereco());
        //dto.setAtivo(entity.getAtivo());

        return dto;
    }

}
