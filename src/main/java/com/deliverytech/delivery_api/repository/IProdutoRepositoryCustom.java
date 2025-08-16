package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import com.deliverytech.delivery_api.model.ProdutoModel;

public interface IProdutoRepositoryCustom {
    // Produtos por restaurante
    List<ProdutoModel> findByRestauranteId(Long restauranteId);

    // Apenas produtos disponíveis
    List<ProdutoModel> findByDisponivelTrue();

    // Produtos por categoria
    List<ProdutoModel> findByCategoria(String categoria);

    // Por faixa de preço (menor ou igual)
    List<ProdutoModel> findByPrecoLessThanEqual(BigDecimal preco);
}
