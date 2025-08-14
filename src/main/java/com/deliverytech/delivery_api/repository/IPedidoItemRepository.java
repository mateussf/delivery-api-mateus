package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.PedidoItemModel;

public interface IPedidoItemRepository extends JpaRepository<PedidoItemModel, Long> {
    // Additional query methods can be defined here if needed

}
