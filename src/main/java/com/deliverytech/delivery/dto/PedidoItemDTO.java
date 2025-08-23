package com.deliverytech.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PedidoItemDTO {
    private Long id;
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
}
