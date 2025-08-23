package com.deliverytech.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
//jakarta é o antigo javax

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurante")
public class RestauranteModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String descricao;

    @OneToMany(mappedBy = "restaurante")
    private List<ProdutoModel> produtos;
}
