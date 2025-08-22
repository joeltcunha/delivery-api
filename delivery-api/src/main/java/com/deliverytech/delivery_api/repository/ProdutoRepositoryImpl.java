package com.deliverytech.delivery_api.repository;

import java.math.BigDecimal;
import java.util.List;

import com.deliverytech.delivery_api.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ProdutoRepositoryImpl implements IProdutoRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> findByRestauranteId(Long restauranteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByRestauranteId'");
    }

    @Override
    public List<Produto> findByDisponivelTrue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDisponivelTrue'");
    }

    @Override
    public List<Produto> findByCategoria(String categoria) {
        // TODO Auto-generated method stub
        String formattedString = String.format("select p from Produto p where categoria = :categoria", categoria);

        TypedQuery<Produto> query = entityManager.createQuery(formattedString, Produto.class);
        return query.getResultList();
    }

    @Override
    public List<Produto> findByPrecoLessThanEqual(BigDecimal preco) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrecoLessThanEqual'");
    }

}
