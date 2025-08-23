package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.service.PedidoServiceImpl;

@CrossOrigin(origins = "*")
@Controller
public class PedidoController {
    private final PedidoServiceImpl pedidoService;

    public PedidoController(PedidoServiceImpl pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping("/api/Pedidos")
    public List<PedidoDTO> listPedidos() {
        return pedidoService.findAll();
    }
}
