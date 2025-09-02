package com.deliverytech.delivery.dto;

import com.deliverytech.delivery.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
