package com.deliverytech.delivery_api.dto;

import lombok.Data;

@Data
public class RestauranteDTO {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;

    public RestauranteDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RestauranteDTO() {
        super();
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
