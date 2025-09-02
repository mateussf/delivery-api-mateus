package com.deliverytech.delivery.service;

import java.util.List;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.dto.PedidoItemDTO;
import com.deliverytech.delivery.model.PedidoModel;

public interface IPedidoItemService {
    public void cadastrarItens(List<PedidoItemDTO> itens, PedidoModel pedidoId);

}
