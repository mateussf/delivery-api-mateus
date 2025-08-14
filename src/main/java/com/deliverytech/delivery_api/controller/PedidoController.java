package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deliverytech.delivery_api.dto.PedidoDTO;
import com.deliverytech.delivery_api.service.PedidoService;

@CrossOrigin(origins = "*")
@Controller
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping("/api/Pedidos")
    public List<PedidoDTO> listPedidos() {
        return pedidoService.findAll();
    }
}
