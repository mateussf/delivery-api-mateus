package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.model.PedidoModel;
import com.deliverytech.delivery.repository.IPedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private IPedidoRepository repository;

    public PedidoServiceImpl(IPedidoRepository restaurantRespository) {
        this.repository = restaurantRespository;
    }

    public PedidoServiceImpl() {
        super();
    }

    public PedidoModel create(PedidoModel pedido) {
        return repository.save(pedido);
    }

    public PedidoModel update(PedidoModel pedido) {
        return repository.save(pedido);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PedidoModel findById(Long id) {
        return repository.findById(id).orElse(null);
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
