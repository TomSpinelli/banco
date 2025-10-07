package com.example.banco.domain.ports;

import com.example.banco.domain.model.CartaoCredito;

import java.util.List;

public interface CartaoServicePort {
    CartaoCredito criarCartao(CartaoCredito cartao);

    List<CartaoCredito> listarCartoes();

    List<CartaoCredito> findByClienteId(Long clienteId);

}
