package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PedidoItemDTO {

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1, message = "Quantidade deve ser pelo menos 1")
    @Max(value = 50, message = "Quantidade não pode exceder 50 unidades")
    private int quantidade;


    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    private List<PedidoItemDTO> itens;

    @NotNull(message = "Produto ID é obrigatório")
    @Positive(message = "Produto ID deve ser positivo")
    private Long produtoId;


    @Size(max = 200, message = "Observações não podem exceder 200 caracteres")
    private String observacoes;
}
