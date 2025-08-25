package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.RestauranteDTO;
import com.deliverytech.delivery.service.IRestauranteService;

@CrossOrigin(origins = "*")
@RestController
public class RestauranteController {

    private final IRestauranteService restaurantService;

    @Autowired
    public RestauranteController(IRestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/api/restaurantes")
    public List<RestauranteDTO> listRestaurants() {
        return null; // restaurantService.findAll();
    }
}
