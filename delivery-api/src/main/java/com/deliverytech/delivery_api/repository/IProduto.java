package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Produto;

public interface IProduto extends JpaRepository <Produto, Long>{

}
