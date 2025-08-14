package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.PedidoModel;

public interface IPedidoRepository extends JpaRepository<PedidoModel, Long> {

}
