package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.PedidoDTO;
import com.deliverytech.delivery.service.IPedidoService;


@CrossOrigin(origins = "*")
@RestController
@Controller
@RequestMapping("/api/Pedidos")
public class PedidoController {
    private final IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/listar")
    public List<PedidoDTO> listPedidos() {
        return pedidoService.findAll();
    }

    @PostMapping("/cadastrar") //não ta funcionando ....
    public ResponseEntity<Long> cadastrarPedido(@RequestBody PedidoDTO dto) {
        Long id = pedidoService.cadastrarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
