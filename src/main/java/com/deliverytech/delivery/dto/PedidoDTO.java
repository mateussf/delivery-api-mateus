package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PedidoDTO {
    private LocalDateTime dataPedido;
    private String enderecoEntrega;
    private BigDecimal subtotal;
    private BigDecimal taxaEntrega;
    private BigDecimal valorTotal;

    private List<PedidoItemDTO> itens;

    private Long restauranteId; // Adicione se necessário
    private Long clienteId; // Adicione se necessário
}
