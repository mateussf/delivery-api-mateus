package com.deliverytech.delivery.dto;

import java.math.BigDecimal;

import com.deliverytech.delivery.model.RestauranteModel;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProdutoDTO {
    private String nome;
    private BigDecimal preco;
    private String categoria;
    private boolean disponivel;



}
