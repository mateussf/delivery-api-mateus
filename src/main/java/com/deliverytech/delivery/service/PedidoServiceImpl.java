package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.model.ClienteModel;
import com.deliverytech.delivery.model.PedidoModel;
import com.deliverytech.delivery.model.ProdutoModel;
import com.deliverytech.delivery.model.RestauranteModel;
import com.deliverytech.delivery.repository.IClienteRepository;
import com.deliverytech.delivery.repository.IPedidoItemRepository;
import com.deliverytech.delivery.repository.IPedidoRepository;
import com.deliverytech.delivery.repository.IRestauranteRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoServiceImpl implements IPedidoService {


    private IPedidoRepository repository;
    private IPedidoItemService pedidoItemService;
    private IClienteRepository clienteRepository;
    private IRestauranteRepository restauranteRepository;

    @Autowired
    public PedidoServiceImpl(IPedidoRepository pedidoRespository, PedidoItemServiceImpl pedidoItemService, IClienteRepository clienreRepository, IRestauranteRepository restauranteRepository) {
        this.repository = pedidoRespository;
        this.pedidoItemService = pedidoItemService;
        this.clienteRepository = clienreRepository;
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    @Transactional
    public Long cadastrarPedido(PedidoDTO pedidodto) {

        ClienteModel cliente = clienteRepository.findById(pedidodto.getClienteId()).orElseThrow(() -> new EntityNotFoundException("Ciente não encontrado"));

        ModelMapper modelMapper = new ModelMapper();
        PedidoModel pedido = modelMapper.map(pedidodto, PedidoModel.class);
        PedidoModel pedidoSalvo = repository.save(pedido);
        pedidoItemService.cadastrarItens(pedidodto.getItens(), pedidoSalvo);
        return pedidoSalvo.getId();
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
