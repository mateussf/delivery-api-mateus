package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.ProdutoModel;

public interface IProdutoRepository extends JpaRepository<ProdutoModel, Long>, IProdutoRepositoryCustom {

}
