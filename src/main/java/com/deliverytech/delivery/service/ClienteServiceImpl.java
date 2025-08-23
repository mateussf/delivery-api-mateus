package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.ClienteDTO;
import com.deliverytech.delivery.model.ClienteModel;
import com.deliverytech.delivery.repository.IClienteRepository;



@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private IClienteRepository repository;

    public ClienteServiceImpl(IClienteRepository repository) {
        this.repository = repository;
    }

    public Long cadastrarCliente(ClienteDTO clienteDTO) {
        this.validaCampos(clienteDTO);

        ModelMapper modelMapper = new ModelMapper();
        ClienteModel cliente = modelMapper.map(clienteDTO, ClienteModel.class);
        ClienteModel ClienteSalvo = repository.save(cliente);

        return ClienteSalvo.getId();
    }

    public void validaCampos(ClienteDTO cliente) {

        if (repository.findByEmail(cliente.getEmail()) != null) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        if (cliente.getTelefone() == null) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        if (cliente.getNome() == null) {
            throw new IllegalArgumentException("Nome inválido");
        }

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
