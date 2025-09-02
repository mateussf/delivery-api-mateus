package com.deliverytech.delivery.dto;

import lombok.Data;

@Data
public class RestauranteDTO {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String descricao;

    public RestauranteDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public RestauranteDTO() {
        super();
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" +
                "name='" + nome + '\'' +
                ", description='" + descricao + '\'' +
                '}';
    }
}
