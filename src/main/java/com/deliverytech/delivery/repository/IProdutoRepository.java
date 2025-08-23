package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.model.ProdutoModel;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, Long>, IProdutoRepositoryCustom {

}
