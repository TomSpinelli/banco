package com.example.banco.domain.ports;

import com.example.banco.domain.model.CartaoCredito;

import java.util.List;

public interface CartaoRepositoryPort {
    CartaoCredito save(CartaoCredito cartao);

    List<CartaoCredito> findAll();

    List<CartaoCredito> findByclienteId(Long clienteId);
}
