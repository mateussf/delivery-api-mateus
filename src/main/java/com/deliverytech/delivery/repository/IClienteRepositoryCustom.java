package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.dto.ClienteDTO;
import com.deliverytech.delivery.model.ClienteModel;

public interface IClienteRepositoryCustom {
    ClienteModel findByEmail(String email);

    boolean existsByEmail(String email);
}
