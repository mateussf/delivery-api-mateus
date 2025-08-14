package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.RestauranteModel;

public interface IRestauranteRepository extends JpaRepository<RestauranteModel, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário

}
