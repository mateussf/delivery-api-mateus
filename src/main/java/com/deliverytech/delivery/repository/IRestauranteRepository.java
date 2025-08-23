package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.model.RestauranteModel;

public interface IRestauranteRepository extends JpaRepository<RestauranteModel, Long>, IRestauranteRepositoryCustom {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário

}
