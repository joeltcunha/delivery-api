package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.entity.Cliente;

public interface IClienteRepository extends JpaRepository <Cliente, Long> {

}
