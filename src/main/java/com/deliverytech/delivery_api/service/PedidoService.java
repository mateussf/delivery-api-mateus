package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.PedidoDTO;
import com.deliverytech.delivery_api.model.PedidoModel;
import com.deliverytech.delivery_api.repository.IPedidoRepository;

@Service
public class PedidoService {
@Autowired
    private IPedidoRepository repository;

    public PedidoService(IPedidoRepository restaurantRespository) {
        this.repository = restaurantRespository;
    }

    public PedidoService() {
        super();
    }

    public List<PedidoDTO> findAll() {
        return repository.findAll().stream().map(this::ConvertEntityToDTO).collect(Collectors.toList());
    }

    private PedidoDTO ConvertEntityToDTO(PedidoModel entity)
    {
        PedidoDTO dto = new PedidoDTO();
        dto.setDataPedido(entity.getDataPedido());
        dto.setEnderecoEntrega((entity.getEnderecoEntrega()));
        dto.setSubtotal(entity.getSubtotal());
        dto.setTaxaEntrega(entity.getTaxaEntrega());
        dto.setValorTotal(entity.getValorTotal());

        return dto;
    }

}
