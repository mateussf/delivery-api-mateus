package com.deliverytech.delivery.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.deliverytech.delivery.dto.ProdutoDTO;
import com.deliverytech.delivery.dto.RestauranteDTO;

public interface IRestauranteService {
    public List<RestauranteDTO> findAll();
    public RestauranteDTO atualizarRestauranre(Long id, RestauranteDTO request);
    public Long cadastrarRestaurante(RestauranteDTO request);
}
