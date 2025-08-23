package com.deliverytech.delivery.model;

import jakarta.persistence.Id;

public enum StatusPedidoModel {
    PENDENTE,
    CONFIRMADO,
    PREPARANDO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO
}
