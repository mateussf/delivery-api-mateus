package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.RestauranteDTO;
import com.deliverytech.delivery_api.service.RestauranteService;

@CrossOrigin(origins = "*")
@RestController
public class RestauranteController {

    private final RestauranteService restaurantService;

    @Autowired
    public RestauranteController(RestauranteService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/api/restaurantes")
    public List<RestauranteDTO> listRestaurants() {
        return null; // restaurantService.findAll();
    }
}
