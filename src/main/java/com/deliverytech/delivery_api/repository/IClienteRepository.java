package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.ClienteModel;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {

}
