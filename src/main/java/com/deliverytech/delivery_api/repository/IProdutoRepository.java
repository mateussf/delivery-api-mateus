package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.ProdutoModel;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, Long>{

}
