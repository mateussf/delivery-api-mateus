package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.RestauranteDTO;
import com.deliverytech.delivery.model.ProdutoModel;
import com.deliverytech.delivery.model.RestauranteModel;
import com.deliverytech.delivery.repository.IRestauranteRepository;

@Service
public class RestauranteServiceImpl implements IRestauranteService {
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

    public RestauranteDTO findById(Long id) {
        return null;//repository.findById(id);
    }

    public Long cadastrarRestaurante(RestauranteDTO restauranteDTO){
        ModelMapper modelMapper = new ModelMapper();
        RestauranteModel produto = modelMapper.map(restauranteDTO, RestauranteModel.class);
        RestauranteModel ProdutoSalvo = repository.save(produto);
        return ProdutoSalvo.getId();
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
