package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestauranteDTO;
import com.deliverytech.delivery_api.model.RestauranteModel;
import com.deliverytech.delivery_api.repository.IRestauranteRepository;

@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    private IRestauranteRepository repository;

    public RestauranteServiceImpl(IRestauranteRepository restaurantRespository) {
        this.repository = restaurantRespository;
    }

    public RestauranteServiceImpl() {
        super();
    }

    public List<RestauranteDTO> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDTO).collect(Collectors.toList());
    }

    private RestauranteDTO ConvertEntityToDTO(RestauranteModel entity)
    {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setName(entity.getNome());
        dto.setDescription((entity.getDescricao()));
        dto.setAddress(entity.getEndereco());
        dto.setPhone(entity.getTelefone());
        dto.setEmail(entity.getEmail());

        return dto;
    }

}
