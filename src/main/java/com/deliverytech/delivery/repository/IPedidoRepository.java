package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.model.PedidoModel;

public interface IPedidoRepository extends JpaRepository<PedidoModel, Long>, IPedidoRepositoryCustom {

}
