package com.deliverytech.delivery_api.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.pedido.entity.Pedido;
import com.deliverytech.delivery_api.repository.IProdutoRepositoryCustom;

@Repository
public interface IPedidoRepository extends JpaRepository <Pedido, Long>, IProdutoRepositoryCustom{

}
