package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deliverytech.delivery.dto.PedidoItemDTO;
import com.deliverytech.delivery.service.PedidoItemService;

@CrossOrigin(origins = "*")
@Controller
public class PedidoItemController {
    private final PedidoItemService pedidoItemService;

    public PedidoItemController(PedidoItemService pedidoItemService) {
        this.pedidoItemService = pedidoItemService;
    }

    @RequestMapping("/api/PedidoItems")
    public List<PedidoItemDTO> listPedidoItems() {
        return pedidoItemService.findAll();
    }
}
