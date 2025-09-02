package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.RestauranteDTO;
import com.deliverytech.delivery.service.IRestauranteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {

    private final IRestauranteService restaurantService;

    @Autowired
    public RestauranteController(IRestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/listar")
    public List<RestauranteDTO> listRestaurants() {
        return restaurantService.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Long> cadastrar(@RequestBody RestauranteDTO dto) {
        Long id = restaurantService.cadastrarRestaurante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PatchMapping("/alterar/{id}")
    public ResponseEntity<RestauranteDTO> atualizarRestauranre(@PathVariable Long id, RestauranteDTO dto) {
        RestauranteDTO restauranteAtualizado = restaurantService.atualizarRestauranre(id, dto);
        return ResponseEntity.ok(restauranteAtualizado);
    }
}
