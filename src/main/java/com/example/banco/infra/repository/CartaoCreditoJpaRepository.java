package com.example.banco.infra.repository;

import com.example.banco.domain.model.CartaoCredito;
import com.example.banco.infra.entity.CartaoCreditoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoCreditoJpaRepository extends JpaRepository<CartaoCreditoEntity,Long> {

    List<CartaoCreditoEntity> findByClienteId(Long clienteId);
}
