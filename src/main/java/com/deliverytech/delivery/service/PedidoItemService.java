package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.PedidoItemDTO;
import com.deliverytech.delivery.model.PedidoItemModel;
import com.deliverytech.delivery.repository.IPedidoItemRepository;

@Service
public class PedidoItemService {

    @Autowired
    private IPedidoItemRepository repository;

    public PedidoItemService(IPedidoItemRepository pedidoItemRepository) {
        this.repository = pedidoItemRepository;
    }

    public PedidoItemService() {
        super();
    }

    public List<PedidoItemDTO> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDTO).collect(Collectors.toList());
    }

    private PedidoItemDTO ConvertEntityToDTO(PedidoItemModel entity)
    {
        PedidoItemDTO dto = new PedidoItemDTO();
        dto.setQuantidade(entity.getQuantidade());
        dto.setPrecoUnitario((entity.getPrecoUnitario()));
        dto.setSubtotal(entity.getSubtotal());


        return dto;
    }

}
