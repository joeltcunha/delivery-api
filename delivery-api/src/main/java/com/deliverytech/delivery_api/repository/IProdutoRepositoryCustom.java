package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import com.deliverytech.delivery_api.entity.Produto;

public interface IProdutoRepositoryCustom {
    // Produtos por restaurante
    List<Produto> findByRestauranteId(Long restauranteId);

    // Apenas produtos disponíveis
    List<Produto> findByDisponivelTrue();

    // Produtos por categoria
    List<Produto> findByCategoria(String categoria);

    // Por faixa de preço (menor ou igual)
    List<Produto> findByPrecoLessThanEqual(BigDecimal preco);

}
