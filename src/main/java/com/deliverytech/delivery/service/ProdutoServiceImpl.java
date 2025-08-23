package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.ProdutoDTO;
import com.deliverytech.delivery.model.ProdutoModel;
import com.deliverytech.delivery.repository.IProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private IProdutoRepository repository;

    public ProdutoServiceImpl(IProdutoRepository respository) {
        this.repository = respository;
    }

    @Override
    public Long cadastrarProduto(ProdutoDTO produtoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ProdutoModel produto = modelMapper.map(produtoDTO, ProdutoModel.class);
        ProdutoModel ProdutoSalvo = repository.save(produto);
        return ProdutoSalvo.getId();
    }

    @Override
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoModel produto = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(produtoDTO.getCategoria());
        produto.setDisponivel(produtoDTO.isDisponivel());
        repository.save(produto);
        return produtoDTO;
    }

    @Override
    public List<ProdutoDTO> buscarProdutosPorRestaurante(Long restauranteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarProdutosPorRestaurante'");
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Long id) {
        return null;
    }

    @Override
    public ProdutoDTO alterarDisponibilidade(Long id, boolean disponivel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarDisponibilidade'");
    }

    @Override
    public ProdutoDTO buscarProdutosPorCategoria(String categoria) {
        List<ProdutoModel> produtos = repository.findByCategoria(categoria);
        if (produtos.isEmpty()) {
            throw new EntityNotFoundException("Nenhum produto encontrado na categoria: " + categoria);
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produtos.get(0), ProdutoDTO.class); // Retorna o primeiro produto encontrado
    }

    @Override
    public List<ProdutoDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return repository.findAll().stream().map(product -> modelMapper.map(product, ProdutoDTO.class)).collect(Collectors.toList());
    }

}









