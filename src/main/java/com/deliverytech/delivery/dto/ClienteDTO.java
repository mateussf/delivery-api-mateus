package com.deliverytech.delivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClienteDTO {

    @NotEmpty(message = "Nome é obrigatória")
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private boolean ativo;
}
