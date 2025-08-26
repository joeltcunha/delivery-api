package com.deliverytech.delivery_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery_api.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {
    // @Query("SELECT COUNT(*) = 1 FROM (SELECT u FROM Cliente u WHERE u.email > : limit 1 AS t")
    Boolean existsByEmail(String email);
    Cliente findByEmail(String email);
    List<Cliente> findByAtivoTrue();
}
