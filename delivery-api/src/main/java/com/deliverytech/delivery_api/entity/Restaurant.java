package com.deliverytech.delivery_api.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurante")

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private long id;
    private String nome;
    @Column(name = "descricao_local")
    private String descricao;
    private String endereco;

    // TABELA PRODUTO MAPEADA PARA RESTAURANTE
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos;

}
