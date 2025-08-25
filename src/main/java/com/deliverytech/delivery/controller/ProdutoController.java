package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dto.ProdutoDTO;
import com.deliverytech.delivery.service.IProdutoService;

import org.springframework.web.bind.annotation.RequestBody;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;

@CrossOrigin(origins = "*")
@RestController
@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final IProdutoService produtoService;

    @Autowired
    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/findAll")
    public List<ProdutoDTO> listProdutos() {
        return produtoService.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Long> cadastrarProduto(@RequestBody  ProdutoDTO dto) {
        Long id = produtoService.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("produto/categoria/{categoria}")
    public ResponseEntity<ProdutoDTO> buscarProdutosPorCategoria(String categoria) {
        ProdutoDTO produto = produtoService.buscarProdutosPorCategoria(categoria);
        return ResponseEntity.ok(produto);
    }

    @PatchMapping("/produto/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto(id, dto);
        return ResponseEntity.ok(produtoAtualizado);
    }
}
