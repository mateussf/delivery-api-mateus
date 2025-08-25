package com.deliverytech.delivery.service;

import java.util.List;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.model.PedidoModel;

public interface IPedidoService {

    public PedidoModel create(PedidoModel pedido);
    public PedidoModel update(PedidoModel pedido);
    public void delete(Long id);
    public PedidoModel findById(Long id);
    public List<PedidoDTO> findAll();
}
