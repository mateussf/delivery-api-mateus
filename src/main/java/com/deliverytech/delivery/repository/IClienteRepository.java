package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.model.ClienteModel;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long>, IClienteRepositoryCustom {

}
