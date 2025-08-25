package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.dto.ClienteDTO;
import com.deliverytech.delivery.model.ClienteModel;
import com.deliverytech.delivery.model.ProdutoModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ClienteRepositoryImpl implements IClienteRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ClienteModel findByEmail(String email) {
        String formattedString = String.format("SELECT p FROM Cliente p WHERE email = :email limit 1", email);
        TypedQuery<ClienteModel> query = entityManager.createQuery(formattedString, ClienteModel.class);
        return query.getSingleResult();
    }



    @Override
    public boolean existsByEmail(String email) {
        return false;//repository.existsByEmail(email);
    }



}
