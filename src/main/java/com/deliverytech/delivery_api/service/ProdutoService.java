package com.deliverytech.delivery_api.service;

import java.util.List;

import com.deliverytech.delivery_api.dto.ProdutoDTO;

public interface ProdutoService {
    public List<ProdutoDTO> buscarProdutosPorRestaurante(Long restauranteId);
    public ProdutoDTO buscarProdutoPorId(Long id);
    public ProdutoDTO alterarDisponibilidade(Long id, boolean disponivel);
    public ProdutoDTO buscarProdutosPorCategoria(String categoria);
    public Long cadastrarProduto(ProdutoDTO produtoDTO);
    public List<ProdutoDTO> findAll();
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);
}
