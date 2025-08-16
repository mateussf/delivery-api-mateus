package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.model.ProdutoModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ProdutoRepositoryImpl  implements IProdutoRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProdutoModel> findByRestauranteId(Long restauranteId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findByRestauranteId'");
        return null;
    }

    @Override
    public List<ProdutoModel> findByDisponivelTrue() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findByDisponivelTrue'");
        return null;
    }

    @Override
    public List<ProdutoModel> findByCategoria(String categoria) {

        String formattedString = String.format("SELECT p FROM Produto p WHERE categoria = :categoria", categoria);
        TypedQuery<ProdutoModel> query = entityManager.createQuery(formattedString, ProdutoModel.class);
        return query.getResultList();
    }

    @Override
    public List findByPrecoLessThanEqual(BigDecimal preco) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findByPrecoLessThanEqual'");
        return null;
    }



}
