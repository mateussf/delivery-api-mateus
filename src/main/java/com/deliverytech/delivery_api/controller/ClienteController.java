package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deliverytech.delivery_api.dto.ClienteDTO;
import com.deliverytech.delivery_api.service.ClienteService;

@CrossOrigin(origins = "*")
@Controller
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("/api/Clientes")
    public List<ClienteDTO> listClientes() {
        return clienteService.findAll();
    }
}
