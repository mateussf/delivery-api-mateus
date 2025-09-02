package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.deliverytech.delivery.dto.ClienteDTO;
import com.deliverytech.delivery.dto.RestauranteDTO;
import com.deliverytech.delivery.model.ClienteModel;
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

    public RestauranteDTO atualizarRestauranre(Long id, RestauranteDTO request){
        ModelMapper modelMapper = new ModelMapper();

        RestauranteModel restauranteCadastrado = repository.findById(id).orElseThrow();
        modelMapper.map(request, restauranteCadastrado);
        RestauranteModel restauranteSalvo = repository.save(restauranteCadastrado);
        return modelMapper.map(restauranteSalvo, RestauranteDTO.class);
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
        dto.setNome(entity.getNome());
        dto.setDescricao((entity.getDescricao()));
        dto.setEndereco(entity.getEndereco());
        dto.setTelefone(entity.getTelefone());
        dto.setEmail(entity.getEmail());

        return dto;
    }

}
